(defproject . "1.0.0-SNAPSHOT"
  :source-path "src/main/clojure"
  :test-path "src/test/clojure"
  :description "FIXME: write"
  :dependencies [
     [org.clojure/clojure "1.8.0"]
		 [org.clojure/tools.nrepl "0.2.3"]
		 [lein-light-nrepl "0.0.17"]
     [revise "0.0.6"]
  ]
  :repl-options {
	:host "localhost"
	:port 9090
	:nrepl-middleware [lighttable.nrepl.handler/lighttable-ops]})
