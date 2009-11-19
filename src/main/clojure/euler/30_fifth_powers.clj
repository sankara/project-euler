(ns euler.30-fifth-powers)

(def atoi #(Character/digit % 10))
(def pow 4)
(def max-n (int (* 6 (Math/pow 9 5))))

(defn is-sum-digit-pow? [n]
    (= n (reduce + (map #(reduce * (repeat pow %)) (map atoi (str n))))))

(println (time
    (reduce + (filter is-sum-digit-pow? (range 2 max-n)))))

;"Elapsed time: 36011.931124 msecs"
;443839

;user=> (* 5 (Math/pow 9 5))
;295245.0
;user=> (* 6 (Math/pow 9 5))
;354294.0
;user=> (* 7 (Math/pow 9 5))
;413343.0
;sum of 9999999 adds up to only 6 digits so no point going above 354294
