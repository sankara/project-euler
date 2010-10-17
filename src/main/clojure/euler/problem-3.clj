(ns euler.problem-3)
(defn div-max ([number divisor]
  (if (zero? (rem number divisor)) (div-max (/ number divisor) divisor) number)
  ))

(defn largest-prime-factor [number] (loop [n number div 2]
  (if (> div n) (- div 1) (recur (div-max n div) (inc div)))))

(println (time (largest-prime-factor 600851475143)))

;"Elapsed time: 17.151064 msecs"
;6857
