import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//BaseURL
String baseURL          = 'https://katalon-demo-cura.herokuapp.com/'

//Username and Password
String username         = 'John Doe'
String password         = 'ThisIsNotAPassword'

// facility: Tokyo / Hongkong / Seoul
String facility         = 'Tokyo'

// readmission: true / false
boolean needReadmission = true

// Program: Medicaid / Medicare / None
String program          = 'Medicaid'

//DateAppointment
String visitDate        = '30/12/2025'

//Comment
String comment          = 'Book appointment'

// Open Browser and go https://katalon-demo-cura.herokuapp.com/
WebUI.openBrowser(baseURL)

// Click button Make Appointment
WebUI.click(findTestObject('HomePage/ButtonMakeAppointment'))

// LoginPage (User Login)
WebUI.setText(findTestObject('LoginPage/UsernameField'), username)
WebUI.setText(findTestObject('LoginPage/PasswordField'), password)
WebUI.click(findTestObject('LoginPage/ButtonLogin'))

//AppointmentPage
//IF–ELSE Option Fasility
if (facility == 'Tokyo') {
	WebUI.click(findTestObject('AppointmentPage/OptionFacilityTokyoCuraHealthcareCenter'))
} else if (facility == 'Hongkong') {
	WebUI.click(findTestObject('AppointmentPage/OptionFacilityHongkongCuraHealthcareCenter'))
} else if (facility == 'Seoul') {
	WebUI.click(findTestObject('AppointmentPage/OptionFacilitySeoulCuraHealthcareCenter'))
}

//IF–ELSE Checkbox Readmission
if (needReadmission) {
	WebUI.check(findTestObject('AppointmentPage/CheckboxApplyForHospitalReadmission'))
} else {
	WebUI.uncheck(findTestObject('AppointmentPage/CheckboxApplyForHospitalReadmission'))
}

//IF–ELSE Radio Program
if (program == 'Medicaid') {
    WebUI.click(findTestObject('AppointmentPage/RadioProgramMedicaid'))
} else if (program == 'Medicare') {
    WebUI.click(findTestObject('AppointmentPage/RadioProgramMedicare'))
} else {
    WebUI.click(findTestObject('AppointmentPage/RadioProgramNone'))
}

// Input Date
WebUI.setText(findTestObject('AppointmentPage/InputVisitDate'), visitDate)

// Input Comment
WebUI.setText(findTestObject('AppointmentPage/TextareaComment'), comment)

// Button SUbmit Appointment
WebUI.click(findTestObject('AppointmentPage/ButtonBookAppointment'))

//Assertion Appointment Confirmation Page
WebUI.verifyElementVisible(findTestObject('AppointmentConfirmationPage/Facility'))
WebUI.verifyElementVisible(findTestObject('AppointmentConfirmationPage/HospitalReadmission'))
WebUI.verifyTextPresent('Please be informed that your appointment has been booked as following:', false)

// Close Browser
WebUI.closeBrowser()
