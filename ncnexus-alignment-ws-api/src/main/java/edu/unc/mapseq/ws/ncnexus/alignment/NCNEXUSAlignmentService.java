package edu.unc.mapseq.ws.ncnexus.alignment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.BindingType;

import org.renci.vcf.VCFResult;

@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_BINDING)
@WebService(targetNamespace = "http://alignment.ncnexus.ws.mapseq.unc.edu", serviceName = "NCNEXUSAlignmentService", portName = "NCNEXUSAlignmentPort")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@Path("/NCNEXUSAlignmentService/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface NCNEXUSAlignmentService {

    @GET
    @Path("/lookupQuantificationResults/{sampleId}")
    @WebMethod
    public QualityControlInfo lookupQuantificationResults(@PathParam("sampleId") @WebParam(name = "sampleId") Long sampleId);

    @GET
    @Path("/identityCheck/{sampleId}")
    @WebMethod
    public VCFResult identityCheck(@PathParam("sampleId") @WebParam(name = "sampleId") Long sampleId);

}
