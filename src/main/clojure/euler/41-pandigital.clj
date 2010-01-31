(ns euler.41
    (:use clojure.contrib.combinatorics))

(defn prime? [p]
    (loop [i 2]
        (cond
            (zero? (mod p i)) false
            (> i (Math/sqrt p)) true
            :else (recur (inc i)))))

(defn main []
    (reduce max
        (filter prime?
            (for [i (range 4 10) j (permutations (range 1 i))]
                (Long/parseLong (apply str j))))))

(println (time (main)))

;"Elapsed time: 1698.589014 msecs"
;7652413
