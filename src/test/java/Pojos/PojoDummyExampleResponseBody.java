package Pojos;

public class PojoDummyExampleResponseBody {

    /*
        {
        "status":"success",
        "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
        "message":"Successfully! Record has been fetched."
        }
     */

    private String status;
    private PojoDummyExampleInnerData data;
    private String message;

    public PojoDummyExampleResponseBody() {
    }

    public PojoDummyExampleResponseBody(String status, PojoDummyExampleInnerData data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    @Override
    public String toString() {
        return "PojoDummyExampleResponseBody{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PojoDummyExampleInnerData getData() {
        return data;
    }

    public void setData(PojoDummyExampleInnerData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
