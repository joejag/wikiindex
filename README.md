# wikiindex

A simple Clojure webservice for searching Wikimedia XML abstracts.

Try it online at https://wikiindex.herokuapp.com

## The problem

WikiMedia publishes an XML abstract of their articles at: http://dumps.wikimedia.org/enwiki/latest/enwiki-latest-abstract23.xml

We want to be able to search on the ```<title>``` and ```<abstract>``` from each abstract in the XML dump.

This search is exposed over an endpoint at: http://localhost:5000/search?q=SearchTerm

The search results will contain the ```<title>```, ```<abstract>``` and ```<url>```:

```
{
 "q":"manchester",
 "results":[
 {
 "title":"Wikipedia: Manchester City",
 "url":"http:\/\/en.wikipedia.org\/wiki\/Manchester_City",
 "abstract":"City in north west England"
 }
 ]
}
```

Constraints:
* Search on single word
* Any doc without a title and abstract can be rejected
* Return an empty string if the url is missing
* There is no need to index the additional links and sublinks in the XML data

## Usage

To run locally:

```
lein run
open http://localhost:5000
```

You can optionally set the port and search results limit:

```
PORT=5001 SEARCH_RESULTS_LIMIT=2 lein run
open http://localhost:5001
```

## Contributing

To start the app in dev mode run the ```develop.sh``` script.

Our architectural decisions have [been recorded](doc/arch)

CI and automatic deployment by Snap-CI: https://snap-ci.com/joejag/wikiindex/branch/master