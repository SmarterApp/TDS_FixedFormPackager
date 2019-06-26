# TDS_FixedFormPackager

The Fixed Form Packager ingests test package information from an Excel (.xlsx) document with multiple worksheets as well as ingests Item metadata from GitLab using the GitLab API and generates a fixed form test package in the 2nd generation (new) format.

## Required Tools
This project uses the following tools

* Java 1.8
* Maven 3

## Required Dependencies
You must build these projects to ensure the necessary dependencies are installed in your local Maven cache

* https://github.com/SmarterApp/TDS_SupportTool

## Building and Running the project
Once you have Java 1.8 and Maven 3 installed you can build the project using the following command (in the projects root directory).

`mvn clean install`

This will build the project creating a `target` directory.  Once the project is built you will see something like:

`target/tds-fixed-form-packager-081320182115.jar`

Once you see that jar you can execute it with:

`java -jar target/tds-fixed-form-packager-081320182115.jar -h`

This will run and present a usage message with the available options.  
<pre>
Error message: Missing required options: t, g, u
 usage: Sample usage: &lt;INPUT_XLSX&gt; [OPTIONS]
  -d,--debug             Prints more verbose debug output in case of errors
  -g,--group <group>     *REQUIRED* GitLab Group
  -h,--help              Prints help statement and exits
  -o,--output <output>   Output path of the generated test package file
                         (current directory by default)
  -t,--token <token>     *REQUIRED* GitLab Token
  -u,--url <url>         *REQUIRED* GitLab URL
</pre>

The sections below cover the required commands and the optional flags that can be provided:

### Options

| Argument | Long Option | Required | Description | Example |
| -------- | ----------- | -------- | ----------- | ------- |
| XLSX_Filename | NA | Yes | The input Excel file containing the test package information. Must be in .XLSX format and not in .XLS format. | ` ./SBAC-IAB-FIXED-G11M-Winter-2017-2018.xlsx`
| `-g` | `--group` | Yes | GitLab Group containing the Item metadata. | `-g ffp-development`|
| `-h` | `--help` | No | Prints out the help/usage statement and exits. | `-h`|
| `-o` | `--output` | No | Output path of the generated test package file. (current directory by default) | `-o ffp-output-directory`|
| `-t` | `--token` | Yes | GitLab token | `-t YOUR_GITLAB_TOKEN`|
| `-u` | `--url` | Yes | GitLab URL | `-u https://gitlab-dev.smarterbalanced.org/`|
| `-d` | `--debug` | No | Verbose logging which can help identify errors | `-d` |


### Example
The example below leverages all the commands listed above. 

`java -jar target/tds-fixed-form-packager-081320182115.jar SBAC-IAB-FIXED-G11M-Winter-2017-2018.xlsx -g ffp-development -o ffp-output-directory -t YOUR_GITLAB_TOKEN -u https://gitlab-dev.smarterbalanced.org/ -d`

The above command will take the Excel document, SBAC-IAB-FIXED-G11M-Winter-2017-2018.xlsx, as input and generate the file ffp-output-directory/SBAC-IAB-FIXED-G11M.xml assuming that the output directory `ffp-output-directory` previously exists.

## GitLab Options

### GitLab Token
Your GitLab token can be generated by going to your profile in your GitLab instance and selecting the "Access Tokens" link. 
(For example: https://gitlab-dev.smarterbalanced.org/profile/personal_access_tokens) 
If you do not already have a token fill out the form to create one and copy the token value somewhere safe. 
This value is the required `-t` option required by the Fixed Form Packager in order for it to read the Item metadata and Item release files from the GitLab API.

### GitLab Group
You must be a member of the GitLab group you are attempting to access at least the Guest level. 
The group can be determined by browsing an Item's metadata and copying the URL segment between the base GitLab URL and the Item directory. 
For example, if you were browsing the Item metadata at 
https://gitlab-dev.smarterbalanced.org/ffp-development/item-XXX-YYYYY 
then the GitLab Group would be "ffp-development".

## Note
The Fixed Form Packager performs validation of the generated test package XML document against the test package schema. 
If the schema validation fails, an error will be reported, but the test package XML document file will still be generated and saved.
