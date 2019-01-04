(ns euler.44-pentagon-sum)

;; Learnt that you can use the concept of an inverse function to check for pentagon numbers. Instead of trying to search
;; them in a huge list. https://en.wikipedia.org/wiki/Inverse_function
;; https://math.stackexchange.com/questions/164645/steps-to-get-inverse-of-pentagonal
;; (1+sqrt(1+24n))/6
(defn- is-pentagonal [n]
  (let [inv (/ (+ 1 (Math/sqrt (+ 1 (* 24 n)))) 6)]
    (if (= inv (Math/floor inv))
      n
      nil)))

;;(is-pentagonal 22)
;;(is-pentagonal 25)

(defn- pentagon [i]
  (/ (* i (- (* 3 i) 1)) 2))
;;(pentagon 1)
;;(pentagon 2)

(loop [i 1 ni (pentagon i)]
  (if-let [nj (first (filter #(and (is-pentagonal (+ ni %))
                                   (is-pentagonal (- ni %)))
                             (map pentagon (range (dec i) 1 -1))))]
    (println i  ni nj (- ni nj))
    (recur (inc i) (pentagon (inc i)))))

;;2167 7042750 1560090 5482660
