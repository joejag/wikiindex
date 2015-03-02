# Search choices

## Context

* As per ADR-001
* In memory search is unacceptably slow

## Decision

* We will Clucy which is a Clojure library on top of Lucene

## Consequences

* Clucy takes 40 minutes to index. This is probably acceptable for a file that only updates twice a month
* Given this startup time, it is undesirable to run in memory
* The response time is now 28ms
* The architecture needs to be remade to run as a separate process

