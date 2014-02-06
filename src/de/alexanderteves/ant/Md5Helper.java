package de.alexanderteves.ant;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.BuildException;

public class Md5Helper extends Task {
    private String property;
    private String message;

    public void setOutputproperty(String property) {
        this.property = property;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void execute() {
        if(this.message == null) {
            throw new BuildException("Missing 'message' attribute");
        } else if(this.property == null) {
            throw new BuildException("Missing 'outputproperty' attribute");
        }
        getProject().setNewProperty(this.property, DigestUtils.md5Hex(this.message));
    }
}
