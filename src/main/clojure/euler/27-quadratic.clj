(ns euler.27
    (:use clojure.contrib.lazy-seqs))

; A rough figure of 100000. If I'm lucky I'll get it right.
(defn primes-as-set []
    (set (take-while #(< % 100000) primes)))

(defn num-consec-primes-in-eq [p-set a b]
    (loop [n 0]
        (let [eq-result (+ (* n n) (* a n) b)]
            (if (not (contains? p-set eq-result))
                n
                (recur (inc n))))))

(defn vec-max
    ([v1 v2] (if (> (last v1) (last v2)) v1 v2)))

(defn main []
    (let [p-set (primes-as-set)]
        (reduce vec-max
            (for [a (range -1000 1001) b (range -1000 1001)]
                [a b (num-consec-primes-in-eq p-set a b)]))))

(println (time (main)))

;"Elapsed time: 4677.183933 msecs"
;[-59231 71]
;"Elapsed time: 3836.486282 msecs"
;[-61 971 71]
;n ^ 2 - 61n + 971 -> Maximum seq of 71 primes.
