;Euler Problem 12
;Triangle number. First one with more than 500 divisors

(defn triangle-numbers []
    (lazy-seq (map first (iterate (fn [[a b]] [(+ a b) (inc b)]) [1 2]))))

;Not sure if it's the property of triangle number but no perfect squares are generated. *definitely not the answer*
(defn count-divisors [n]
    (let [sn (int (. Math sqrt n))]
        (* 2 (count (filter zero? (map mod (repeat sn n) (range 1 (inc sn))))))))

(defn get-tri-n-with-div [min-div]
    (first (filter #(>= (count-divisors %) min-div) (triangle-numbers))))

(println (time (get-tri-n-with-div 500)))

;"Elapsed time: 155144.994329 msecs"
;76576500

;"Elapsed time: 169227.045338 msecs"
;76576500

;(println (count-divisors 62370000))
