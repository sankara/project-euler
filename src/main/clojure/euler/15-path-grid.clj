(ns euler.15-path-grid)

(defn path-grid [n m]
    (let [next-n (if (> n 0) (dec n) 0)
          next-m (if (> m 0) (dec m) 0)]
        (if (or (zero? n) (zero? m))
            1
            (+ (path-grid n next-m) (path-grid next-n m)))))

(def path-grid (memoize path-grid))

(println (time (path-grid 20 20)))

;"Elapsed time: 50.08158 msecs"
;137846528820

;After memoization.
;"Elapsed time: 7.532565 msecs"
;137846528820

; Another solution 40!/(20!20!)
