(ns adventofcode.2019.day08
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def fixture
  (-> "2019/day08"
      io/resource
      io/reader
      slurp
      str/trim-newline))

(def black \0)
(def white \1)
(def transparent \2)

(defn checksum
  [freqs]
  (* (get freqs white)
     (get freqs transparent)))

(defn verify
  [image width height]
  (->> image
       (partition (* width height))
       (map frequencies)
       (sort-by #(get % black) <)
       first
       checksum))

(defn part1
  []
  (verify fixture 25 6))

(defn first-colour
  [pixels]
  (some #{black white} pixels))

(defn fill
  [pixel]
  (if (= pixel black) "▓" "░"))

(defn decode
  "decode a multi layer image to a single layer"
  [image width height]
  (let [layer-size (* width height)
        layer-count (/ (count image) layer-size)]
    (->> image
         (partition layer-size) ;; by layer
         (apply interleave)
         (partition layer-count) ;; by pixel
         (map first-colour))))

(defn render
  "render a single layer image"
  [image width]
  (->> image
       (map fill)
       (partition width)
       (map (partial apply str))))

(defn part2
  []
  (let [[width height] [25 6]]
       (-> fixture
           (decode width height)
           (render width))))
