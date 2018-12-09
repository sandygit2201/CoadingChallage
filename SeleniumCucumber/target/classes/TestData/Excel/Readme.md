Steps to run scripts:
1. Create the feature file under project's "Features" folder.
2. Go to Runner class and add the tags of the scenarios need to be run.
3. Run as JUnit Test.
4. Results can be found under target folder.

About Framework:
1. FW has a runner class. When you run the class as JUnit Test, execution starts.
2. When the execution starts, pico container will intialize the "ApplicationContext" class by running it constructor.
3. ApplicationContext gets initialized for each scenario defined that is getting executed.
4. During the initialization of ApplicationContext, in the constructor, following classes also will be intialized
	a. WebDriverHandler
	b. PageObjectHandler
	c. Application
	d. JSONDataReader
5. WebDriverHandler - During the initialization of this class FileReaderHandler (Singleton class) will be intialized.
   Which inturn will initalize ConfigFileReader class.
   FileReaderHandler - Is a Singleton class hold the reference of ConfigFileReader. 
   ConfigFileReader -  Is a class which while initializing reads the 'projectconfig.properties' file and creates 'Properties' object
   projectconfig.properties - contains the following details
	url - URL of the application
	browsertype - Browser type by which WebDriver needs to b initialized
	environment - If the execution is done locally or remote using selenium grid
	implicitwait - seconds to be wait by webdriver implicitly
	driverpath - Path of the exe files for driver initialization
	propertiespath - Path for log4j config file
	jsonpath - Path for JSON files
	excelpath - Path of Excel files
	uploadablefilespath - Path for files used for uploading in the application
	
6. During the step definition execution, when any of the step need to be executed for the first time, the particular classes constructor
   will be run and the referncet to the existing ApplicationContext object will stored to the local instance variable.
   Similarly, it will initialize the respective page object and its reference will be stored in the "PageObjectHandler" object.
   
7. The above step applies for all the step definition classes when executed for the first time.

8. Note1: All the selenium actions are written in Application class so that it does not have to be repeated in each page objects and maintaining will be easy
9. Note2: For form related data, data is maintained in json file. A java POJO object will be created out of it which will be avilable untill the scenario
   so that filled data can be verified back.
10. @After cucumber hook is used which executes after each scenario.
	If scenario fails then application will logout and then closes otherwise it closes directly.
	
	