(ns jayq.macros)

(defmacro queue
  [elem & body]
  `(jayq.core/queue ~elem
                    (fn []
                      (cljs.core/this-as ~'this
                                         ~@body))))

(defmacro ready
  [& body]
  `(jayq.core/document-ready (fn []
                               ~@body)))

(defmacro getter-or-setter
	[attr]
	`(defn ~attr
			([$elem]
   			(. $elem ~attr))
  		([$elem value]
    		(. $elem ~attr value))))