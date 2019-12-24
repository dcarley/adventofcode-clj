(ns adventofcode.2019.day06-test
  (:require [clojure.test :refer :all]
            [adventofcode.2019.day06 :as day06]
            [clojure.string :as str]))

(def example
  (str/split-lines "COM)B
B)C
C)D
D)E
E)F
B)G
G)H
D)I
E)J
J)K
K)L"))

(deftest day06
  (testing "orbit-map"
    (is (= {"B" "COM"
            "C" "B"
            "D" "C"
            "E" "D"
            "F" "E"
            "G" "B"
            "H" "G"
            "I" "D"
            "J" "E"
            "K" "J"
            "L" "K"}
           (day06/orbit-map example))))

  (testing "count-parents"
    ;; D directly orbits C and indirectly orbits B and COM, a total of 3 orbits.
    (is (= 3 (day06/count-parents (day06/orbit-map example) "D")))
    ;; L directly orbits K and indirectly orbits J, E, D, C, B, and COM, a total of 7 orbits.
    (is (= 7 (day06/count-parents (day06/orbit-map example) "L")))
    ;; COM orbits nothing.
    (is (= 0 (day06/count-parents (day06/orbit-map example) "COM"))))

  (testing "part1 solution"
    (is (= 160040 (day06/part1)))))

