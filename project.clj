(defproject adventofcode "0.1.0-SNAPSHOT"
  :description "Advent of Code solutions in Clojure"
  :url "https://github.com/dcarley/adventofcode-clj"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :pedantic? :abort
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/data.csv "0.1.4"]
                 [org.clojure/math.combinatorics "0.1.6"]]
  :profiles {:dev {:dependencies [[lambdaisland/kaocha "1.0.732" :exclusions [org.clojure/spec.alpha]]]}}
  :aliases {"test" ["run" "-m" "kaocha.runner"]})
