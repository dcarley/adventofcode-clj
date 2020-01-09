(ns adventofcode.2019.day06-test
  (:require [clojure.test :refer :all]
            [adventofcode.2019.day06 :as day06]
            [clojure.string :as str]))

(def example-input1
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

(def example-input2
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
K)L
K)YOU
I)SAN"))

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
           (day06/orbit-map example-input1))))

  (testing "part1 examples"
    (let [example (day06/orbit-map example-input1)]
      ;; D directly orbits C and indirectly orbits B and COM, a total of 3 orbits.
      (let [parents (day06/orbit-parents example "D")]
        (is (= '("C" "B" "COM") parents))
        (is (= 3 (count parents)))

      ;; L directly orbits K and indirectly orbits J, E, D, C, B, and COM, a total of 7 orbits.
      (let [parents (day06/orbit-parents example "L")]
        (is (= '("K" "J" "E" "D" "C" "B" "COM") parents))
        (is (= 7 (count parents)))

      ;; COM orbits nothing.
      (let [parents (day06/orbit-parents example "COM")]
        (is (= '() parents))
        (is (= 0 (count parents))))))))

  (testing "part1 solution"
    (is (= 160040 (day06/part1))))

  (testing "part2 examples"
    (let [example (day06/orbit-map example-input2)]
      (let [transfers (day06/orbit-transfers example "YOU" "SAN")]
        (is (= #{"K" "J" "E" "I"} transfers))
        (is (= 4 (count transfers))))))

  (testing "part2 solution"
    (is (= 373 (day06/part2)))))
