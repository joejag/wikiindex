(ns wikiindex.plumbing.db-test
  (:require [midje.sweet :refer :all]
            [wikiindex.plumbing.db :as subject]))

(def manchester {:title "Manchester" :abstract "Manchester is a city" :url "url"})

(fact "can search for a document"
      (let [db (subject/create-db)]
        (subject/index db manchester)
        (subject/search db "Manchester")) => [manchester])
