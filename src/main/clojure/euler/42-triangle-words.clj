(ns euler.42
    (:use clojure.contrib.duck-streams)
    (:use clojure.contrib.str-utils))

(defn triangle-series [n]
    (for [i (range 1 (inc n))] (/ (* i (inc i)) 2)))

(def words
    (map #(re-gsub #"[^A-Z]" "" %)
        (re-split #"," (first (read-lines "words.txt")))))

(defn sum-char-word [word]
    (reduce + (map #(+ 1 (- (int %) (int \A))) (str word))))

(defn triangle-words []
    (let [set-t (set (triangle-series 1000))]
        (filter #(contains? set-t (sum-char-word %)) words)))

(defn main [] (count (triangle-words)))

(println (time (main)))

;"Elapsed time: 323.165348 msecs"
;162
