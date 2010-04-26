(ns euler.utils
  (:require [clojure.contrib.math :only expt :as math]))

(def *prime-max-tries* 100)

(defn prime? [n]
  (loop [c *prime-max-tries*]
    (let [a (rand-int n)]
      (cond
        (not= a (long (mod (math/expt a n) n))) false
        (= c 0) true
        :else (recur (dec c))))))
