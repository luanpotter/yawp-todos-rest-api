# yawp-todos-rest-api

[![Build Status](https://travis-ci.org/luanpotter/yawp-todos-rest-api.svg?branch=master)](https://travis-ci.org/luanpotter/yawp-todos-rest-api)

This is a CRUD REST api for a todo model with two fields: a Long id and a String text (text of the todo).

It uses [Yawp!](https://yawp.io/) and the Google AppEngine platform with Datastore as the database.

## Setup

Run

```bash
  mvn clean install
```

To download all dependencies and such, then start the API with

```bash
  mvn yawp:devserver
```

Alternatively, you can import to Intellij IDEA (via the Import maven project option) and then use the commands from the IDE to run.
