(ns euler.32-pandigital-product
  (:use clojure.contrib.combinatorics))

(defn pandigital? [num]
  (let [s (str num)]
    (and
      (= 9 (count s))
      (= #{\1 \2 \3 \4 \5 \6 \7 \8 \9} (set s)))))

(defn main []
  (reduce + (distinct (map last
    (filter #(pandigital? (str (first %) (second %) (last %)))
      (for [i (range 1 99) j (range 1 9999)]
        [i j (* i j)]))))))

;(println (time (main)))

;"Elapsed time: 3432.904263 msecs"
;45228
