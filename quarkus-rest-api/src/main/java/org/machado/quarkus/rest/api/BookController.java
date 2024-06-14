package org.machado.quarkus.rest.api;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/v1/books")
public class BookController {

    @Inject
    BookService bookService;

    @GET
    public Response readAll() {
        return Response.ok(bookService.readAll()).build();
    }

    @GET
    @Path("{id}")
    public Response readOne(@PathParam("id") String id) {
        return Response.ok(bookService.readOne(id)).build();
    }

    @POST
    public Response create(@Valid Book book) {
        return Response.status(201).entity(bookService.insert(book)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(Book book, @PathParam("id") String id) {
        bookService.update(book, id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        bookService.delete(id);
        return Response.noContent().build();
    }

}
