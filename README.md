# LambdatestCodeChallenge

## Table of Contents
1. [Overview](#overview)
2. [Test automation strategy](#test_automation_strategy)
3. [Automation backlog](#Automation_backlog)
4. [Automation backlog](#Automation_backlog)
5. [Lambdatest Project](#LambdatestProject)

---

## Overview
This directory contains LambdatestCodeChallenge tests for the https://ecommerce-playground.lambdatest.io/ site. It includes documentations (such as Test strategy, list of Test cases - Automation backlog, Report file) and IntelliJ project with automated tests for different functionalities. Following common business logic I've decided to prioritize as "Highest" and automate the E2E scenarios, including Login, Regsitration, Search, Add to cart, Check out as logged in user and as a guest user.

---

## Test automation strategy
Defines the core of automatin testing such as: goal, scope, entry and exit criteria, test levels,test types, test design techniques used, tools, environment, risks & schedule.

---

## Automation backlog
A table of test scenarios to be automated. Tests are grouped into Suites ond prioritized accordingly.

---

## Report
A simple excel file with charts showing the progress with the Test Automation process.

---


## Lambdatest Project
IntelliJ project, using Selenium WebDriver to automate the test process. I am using POM to hide implementation details, reduce duplication of code and get more readable tests. Project is grouped into packages. I use properties file (map.properties) to store data (string I use as parameters, settings, urls, login details, etc.) I use for testing purposes.

---