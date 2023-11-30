package me.hyname.route;

import java.io.ByteArrayOutputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.model.ErrorResponse;

public class ErrorMessageGenerator {

    JAXBContext jaxb;

    public ErrorMessageGenerator(JAXBContext jaxb) {
        this.jaxb = jaxb;
    }

    public byte[] generateErrorResponse(int returnCode, String stackTrace, String path) {
        ErrorResponse error = new ErrorResponse(returnCode, stackTrace, path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            Marshaller marshallerObj = jaxb.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshallerObj.marshal(error, baos);

            return baos.toByteArray();
        } catch (JAXBException e) {
            //if this fails, is there really any hope?
            StringBuilder utterFailure = new StringBuilder();
            utterFailure.append("Failed spectacularly.  Attempt to generate error message with the following details in XML, but failed:\n");
            utterFailure.append("Response Status: " + returnCode + "\n");
            utterFailure.append("Stacktrace:\n\t" + stackTrace + "\n");
            utterFailure.append("Request Path:\n\t" + path);

            return utterFailure.toString().getBytes();
        }

    }
}
