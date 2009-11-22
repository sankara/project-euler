(ns euler.34)

(def atoi #(Character/digit % 10))
(def fact-map {0 1 1 1 2 2 3 6 4 24 5 120 6 720 7 5040 8 40320 9 362880})

(defn sum-digit-fact [n]
    (reduce + (map #(get fact-map %) (map atoi (reverse (str n))))))

(println (time (reduce + (filter #(= % (sum-digit-fact %)) (range 3 100000)))))

;"Elapsed time: 258850.479561 msecs"
;40730

; There are just 4 factorians btw. 1, 2, 145, 40585
