*** Settings ***
Library  SeleniumLibrary    

*** Variables ***
${BROWSER}    chrome
${HEADLESS}    false
${url}    http://127.0.0.1:5500/src/main/Js/HTML/ManagementSystem.html

*** Keywords ***
Start TestCase
    Open Browser  ${url}  ${BROWSER}
    Maximize Browser Window

Add modal display
    Click Button  //*[@id="addBtn"] 
    Element Should Contain  //*[@id="addModal"]/div/div
    ...

Add function
    Click Button  //*[@id="addBtn"] 
    Element Should Contain  //*[@id="addModal"]/div/div
    ...
    Sleep  3s
    Input Text  //*[@id="addstudentname"]  Ho Nguyen
    Sleep  3s
    Input Text  //*[@id="addstudentemail"]  honguyen@hotmail.com
    Sleep  3s
    Input Text  //*[@id="addsubjectone"]  7.8
    Sleep  3s
    Input Text  //*[@id="addsubjecttwo"]  5.0
    Sleep  3s
    Input Text  //*[@id="addsubjectthree"]  8.5
    Sleep  3s
    Click Button  //*[@id="addstudentbtn"] 
    Sleep  3s

Leave Blank "Student name" text field
    Click Button  //*[@id="addBtn"] 
    Element Should Contain  //*[@id="addModal"]/div/div
    ...
    Sleep  3s
    Click Button  //*[@id="addstudentbtn"] 
    Sleep  3s

Finish TestCase
    Close Browser
    


*** Test Cases ***
Verify that the "Add Student" modal will be displayed when user click on the "Add" button
    Start TestCase
    Add modal display
    Finish TestCase

Verify that the user can add student information successfully
    Start TestCase
    Add function
    Finish TestCase

Verify that the user cannot leave blank the Student name field on the Add Student modal
    Start TestCase
    Leave Blank "Student name" text field
    Finish TestCase


