package lv.javaguru.productlist.businesslogic.validation;

import java.util.List;

public class ProductValidationResponse {

    private boolean success;
    private List<String> errorMessages;

    public ProductValidationResponse(boolean success,
                                     List<String> errorMessages) {
        this.success = success;
        this.errorMessages = errorMessages;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
