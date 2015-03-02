(ns wikiindex.core.routing-test
  (:require [midje.sweet :refer :all]
            [wikiindex.plumbing.db :as db]
            [wikiindex.core.routing :as subject]))

(fact "home page route exists"
      ((subject/app []) {:uri "/" :request-method :get}) => (contains {:body anything}))

(fact "search route exists"
      ((subject/app []) {:uri "/search" :request-method :get}) => (contains {:body anything})
      (provided (db/search anything anything) => []))