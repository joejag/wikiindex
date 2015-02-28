# Search choices

## Context

We need to index and search a 32Mb XML file.
The search is across multiple fields.
Only one search word is used.
We currently don't have any external platform tools like Mongo, ElasticSearch, an RDMS
We do not know how often the XML file will be updated.

## Decision

We will parse the file on startup, store it as a clojure map in an atom.
We will do this before the web server http port is available.
Searches will be performed against this in memory atom.
The app would need to be restarted to parse a new XML file, unless an additional endpoint is added.

## Alternatives considered

We could use ElasticSearch.
A separate process would convert the XML to JSON then index it into ElasticSearch.
Our web app would then pass on the search request from the user to ElasticSearch.

A document database like Mongo could store a JSON representation.
It's native search would probably .
This approach can be taken it the atom approach takes too long to index the XML file on startup.
