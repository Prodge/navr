(ns navr.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [navr.core-test]))

(doo-tests 'navr.core-test)
