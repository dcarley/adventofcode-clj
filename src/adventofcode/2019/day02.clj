(ns adventofcode.2019.day02
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

(def fixture
  (->> "2019/day02"
      io/resource
      io/reader
      csv/read-csv
      first
      (mapv #(Integer/parseInt %))))

(defn op
  "Run an opcoce on two inputs.
  Halt (99) and unknown opcodes are handled upstream of this."
  [opcode x y]
  (condp = opcode
   1 (+ x y)
   2 (* x y)))

(defn deref-value
  "Deference a value from an index stored in at another index."
  [intcodes index]
  (nth intcodes (nth intcodes index)))

(defn step
  "Execute one step/pass of the program."
  [intcodes index]
  (let [opcode (nth intcodes index)
        x      (deref-value intcodes (+ index 1))
        y      (deref-value intcodes (+ index 2))
        out    (nth intcodes (+ index 3))]
    (assoc intcodes out (op opcode x y))))

(defn execute
  "Keep executing steps until we encounter an opcode greater than 2."
  [program]
  (loop [intcodes program
         index    0]
    (if (> (nth intcodes index) 2)
      intcodes
      (recur (step intcodes index) (+ index 4)))))

(defn restore-state
  "Restore the gravity assist program (your puzzle input) to the '1202 program
  alarm' state it had just before the last computer caught fire. To do this,
  before running the program, replace position 1 with the value 12 and replace
  position 2 with the value 2."
  [intcodes]
  (assoc intcodes
         1 12
         2 2))

(defn part1
  []
  (-> fixture
      restore-state
      execute
      first))
