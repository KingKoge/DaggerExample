package me.developer.suttichai.dagger.api.menu.request;

public class MenuBody {
    private String version;
    private String method;
    private String branchId;
    private String packageId;
    private String flag;

    public MenuBody(String version, String method, String branchId, String packageId, String flag) {
        this.version = version;
        this.method = method;
        this.branchId = branchId;
        this.packageId = packageId;
        this.flag = flag;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
