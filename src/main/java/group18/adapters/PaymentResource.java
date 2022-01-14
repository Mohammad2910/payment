package group18.adapters;

import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceService;
import group18.adapters.BankWrapper;
import group18.domain.PaymentRegistration;
import group18.domain.model.Payment;
import group18.domain.ports.IBankWrapper;
import group18.domain.ports.IPaymentResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/payment")
public class PaymentResource implements IPaymentResource {

    /*
    TODO Should not make these instances, instead use a facade microservice that provides these.

     */
    BankServiceService bankService = new BankServiceService();

    IBankWrapper bankWrapper = new BankWrapper(bankService);

    PaymentRegistration payService = new PaymentRegistration(bankWrapper);

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response add(Payment payment) {
        try {
            payService.createPayment(payment);
            return Response.status(Response.Status.OK).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND.getStatusCode()).header("errMsg", e.getMessage()).build();
        }
    }
}