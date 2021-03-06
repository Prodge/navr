(ns navr.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:body {:color "#222"}]
  [:.task {:display "flex"
           :flex-direction "row"
           :flex-grow 0
           :flex-wrap "wrap"
           :width "100%"
           :padding-left "15px"
           :padding-right "15px"
           :border-bottom "2px solid #e0e0e0"
           :border-collapse "collapse"
           :padding-top "5px"}
    [:header {:background-color "#FFEEDB"
              :font-weight "bold"
              :padding-tpo "8px"
              :padding-buttom "8px"}]
    [:.text {:flex-grow 1
             :overflow "hidden"
             :white-space "nowrap"
             :text-overflow "ellipsis"
             :padding-right "20px"
             :width "180px"}]
    [:.num {:width "80px"}]
   ]

)

;.hamburger {
  ;padding: 15px 15px;
  ;display: inline-block;
  ;cursor: pointer;
  ;transition-property: opacity, filter;
  ;transition-duration: 0.15s;
  ;transition-timing-function: linear;
  ;font: inherit;
  ;color: inherit;
  ;text-transform: none;
  ;background-color: transparent;
  ;border: 0;
  ;margin: 0;
  ;overflow: visible; }
  ;.hamburger:hover {
    ;opacity: 0.7; }

;.hamburger-box {
  ;width: 40px;
  ;height: 24px;
  ;display: inline-block;
  ;position: relative; }

;.hamburger-inner {
  ;display: block;
  ;top: 50%;
  ;margin-top: -2px; }
  ;.hamburger-inner, .hamburger-inner::before, .hamburger-inner::after {
    ;width: 40px;
    ;height: 4px;
    ;background-color: #000;
    ;border-radius: 4px;
    ;position: absolute;
    ;transition-property: transform;
    ;transition-duration: 0.15s;
    ;transition-timing-function: ease; }
  ;.hamburger-inner::before, .hamburger-inner::after {
    ;content: "";
    ;display: block; }
  ;.hamburger-inner::before {
    ;top: -10px; }
  ;.hamburger-inner::after {
    ;bottom: -10px; }



;.hamburger--elastic .hamburger-inner {
  ;top: 2px;
  ;transition-duration: 0.275s;
  ;transition-timing-function: cubic-bezier(0.68, -0.55, 0.265, 1.55); }
  ;.hamburger--elastic .hamburger-inner::before {
    ;top: 10px;
    ;transition: opacity 0.125s 0.275s ease; }
  ;.hamburger--elastic .hamburger-inner::after {
    ;top: 20px;
    ;transition: transform 0.275s cubic-bezier(0.68, -0.55, 0.265, 1.55); }

;.hamburger--elastic.is-active .hamburger-inner {
  ;transform: translate3d(0, 10px, 0) rotate(135deg);
  ;transition-delay: 0.075s; }
  ;.hamburger--elastic.is-active .hamburger-inner::before {
    ;transition-delay: 0s;
    ;opacity: 0; }
  ;.hamburger--elastic.is-active .hamburger-inner::after {
    ;transform: translate3d(0, -20px, 0) rotate(-270deg);
    ;transition-delay: 0.075s; }

