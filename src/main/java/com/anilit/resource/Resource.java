package com.anilit.resource;

import com.anilit.dto.Account;
import com.anilit.service.AccountService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.Logger;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Resource {

    public static final Logger LOG = Logger.getLogger(Resource.class);

    @Inject
    AccountService accountService;

    @POST
    @Path("open_account")
    public Response openAccount(@RequestBody Account account) {
        LOG.info("Entering in Response::openAccount()");
        LOG.debug("Response::openAccount() Account anil part1 " + account);

        boolean alreadyExist = accountService.isAccountAlreadyExist(account);
        LOG.debug("Response::openAccount() Account " + alreadyExist);
        if (alreadyExist) {
            LOG.info("Returning from Resource::openAccount() anilpart 2");
            return Response.ok("Oops! Account already Exist").build();
        }else {
            LOG.info("Returning from Resource::openAccount() anil part3");
            return Response.ok("Thanks for opening account......").build();
        }
    }
}
