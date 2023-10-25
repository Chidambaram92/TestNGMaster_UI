package com.selenium.constants;

public class FrameWorkConstants {
    private static final String PROJECT_PATH=System.getProperty("user.dir");
    public static final String ASSERTION_FOR_RESPONSE_STATUS_CODE = "Assertion for Response Status Code";

    private static final int EXPLICIT_WAIT = 20;
    public static final int WAIT = 10;

    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + "/ExtentReports/";
    public static final String EXTENT_REPORT_NAME = "AutomationReport.html";
    private static String extentReportFilePath = "";

    public static final String Zipped_ExtentReports_Folder_Name = "ExtentReports.zip";
    private static final String Project_Name = "Automation Test Suite Report - Master Selenium Framework";

    public static String getExtentReportFilePath(){
        if (extentReportFilePath.isEmpty()){
            // extentReportFilePath=
        }
        return extentReportFilePath;
    }
    public static int getExplicitWait(){
        return EXPLICIT_WAIT;
    }
}
