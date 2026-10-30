package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static Common.CommonTestData.*;
import static Common.GenerateTestData.*;
import static requestBuilder.RequestBuilder.*;

public class NdosiAutomationAPITests {
    @Test
    @Description("As an api user i want to create the new user")
    @Severity(SeverityLevel.BLOCKER)
    public void registerUserTests() {
        createUserResponse(firstName, lastName, email, password, confirmPassword, groupId).
                then().
                assertThat().
                statusCode(Creation_Success);
    }

    @Test(dependsOnMethods = "registerUserTests")
    @Description("As an api user i want to login as admin user")
    @Severity(SeverityLevel.BLOCKER)
    public void loginAsAdminUserTests() {
        loginrResponse(adminUsername, adminPassword).
                then().
                assertThat().
                statusCode(Success_Status);
    }
    @Test(dependsOnMethods = "loginAsAdminUserTests")
    @Description("As an api user i want to approve the user")
    @Severity(SeverityLevel.BLOCKER)
    public void approveUserTests() {
        approveUser().
                then().
                assertThat().
                statusCode(Success_Status);
    }

    @Test(dependsOnMethods = "loginAsAdminUserTests")
    @Description("As an api user i want to enroll a user to a course")
    @Severity(SeverityLevel.BLOCKER)
    public void enrollUserToCourseTests() {
        enrollUserToCourse(userId, courseId, notes).
                then().
                assertThat().
                statusCode(Creation_Success);
    }

    @Test(dependsOnMethods = "loginAsAdminUserTests")
    @Description("As an api user i want to verify the enrollment of a user to a course")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyEnrollmentTests() {
        verifyEnrollment(enrollmentId).
                then().
                assertThat().
                statusCode(Success_Status).
                body("data.enrollment.Status", equalTo("enrolled"));
    }
}
