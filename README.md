BugTrack System
Overview
The BugTrack System is a web application designed to track and manage bugs within a project. This system provides functionality to add new bugs, update existing ones, mark them as resolved, and view lists of bugs filtered by their status (resolved, active, or all).
In order to run the project, you have to go into application.properties and add your credentials.

Features
Add New Bug: Submit details of a new bug including name, description, reporter, severity, and dependencies.
Update Bug: Update details of an existing bug.
Resolve Bug: Mark a bug as resolved.
View Resolved Bugs: Retrieve a list of all resolved bugs.
View Active Bugs: Retrieve a list of all active (unresolved) bugs.
View All Bugs: Retrieve a comprehensive list of all bugs in the system.

Endpoints
GET /bug/resolved-bugs
Returns a list of resolved bugs.

Response
200 OK.
Time: 23ms.

GET /bug/active-bugs
Returns a list of active (unresolved) bugs.

Response
200 OK.
Time: 45ms.

GET /bug/all-bugs
Returns a list of all bugs.

Response
200 OK.
Time: 35ms.

POST /bug/add
Adds a new bug to the system.

Request Body

BugRequest:
name (String): Name of the bug.
description (String): Description of the bug.
reporter (User): User who reported the bug.
severity (int): Severity level of the bug.
dependencies (List<Bug>): List of dependencies.
Response

200 OK.
Time: 31ms.

PUT /bug/update/{id}
Updates an existing bug.

Path Variable

id (Long): ID of the bug to update.
Request Parameters

name (String): Updated name of the bug.
description (String): Updated description of the bug.
severity (int): Updated severity level of the bug.
Response

200 OK.
Time: 25ms.

PUT /bug/resolve/{id}
Marks a bug as resolved.

Path Variable

id (Long): ID of the bug to resolve.
Response

200 OK.
Time: 25ms.# BugTrack
