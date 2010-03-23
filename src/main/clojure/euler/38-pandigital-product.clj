(ns euler.38
  (:require [euler.32-pandigital-product :as utils]))


(defn main []
  (reduce max
    (map #(Integer/parseInt %)
      (filter utils/pandigital?
        (for [i (range 1 10000) j (range 2 6)]
          (reduce str
            (for [k (range 1 (inc j))]
              (* i k))))))))

(println (time (main)))

;"Elapsed time: 487.121677 msecs"
;932718654
