import org.apache.spark.{SparkConf, SparkContext}

object wordgrouping {

  def main(args: Array[String]) {
    //    System.setProperty("hadoop.home.dir", "E:\\UMKC\\Sum_May\\KDM\\winutils")
    val conf = new SparkConf().setAppName("group by example").setMaster("local").set("spark.driver.host","localhost")
    val sc = new SparkContext(conf)
    val f=sc.textFile("/Users/rohithkumarn/Documents/GitHub/CS5542-BigDataAnalytics-RohithKumar/ICP-2/source/icp2/src/main/scala/input")
    val wc=f.flatMap(line=>{line.split(" ")})
    val out=wc.groupBy(word=>word.charAt(0))
    out.collect.foreach(print)
  }
}

/*
output:


(T,CompactBuffer(The, The, The, The, The, T))
(w,CompactBuffer(weapons, with, warhead,, were, warheads, were, were, with, warheads, were, warheads, were, weapons., was, which, weapon, war., which, were, weapons, were, were, weapons, were, weapons, weapons, within, with, weapons., were, which, were))
(s,CompactBuffer(supposed, storage, security, significant, standards, sensitive, suspended., security))
(D,CompactBuffer(Dakota, During, Department, Defense, Defense, Department, Defense))
(e,CompactBuffer(each, existed))
(d,CompactBuffer(does, disciplined, decertified, duties,, did))
(L,CompactBuffer(Louisiana.))
(p,CompactBuffer(period,, protected, precautions, procedures, personnel, personnel, perform, procedures., panel, procedures, processes, personnel.))
(",CompactBuffer("blue))
(G,CompactBuffer(General, Global))
(M,CompactBuffer(Minot, Minot, Minot, Michael, Michael, Moseley))
(g,CompactBuffer(given.))
(5,CompactBuffer(5))
(a,CompactBuffer(a, a, at, and, and, aircraft, at, and, and, as, a, a, and, an, and, a, and/or, and, and, at, addition,, and, and, a, and, any, and, and, asked, a, announced, all, and))
(B,CompactBuffer(B-52H, Base, Barksdale, Base, Barksdale, Bent, Base, Board, Based))
(t,CompactBuffer(transported, to, the, to, the, taken, their, the, to, the, this, the, the, to, the, top, the, to, that, the, threat, to, the, the, the, that, the, their, to, types, transport, the, the, that, the, the, the, this, the, the, their, to, the, the, to))
(i,CompactBuffer(incident, in, in, in, incident, incident,, indicates, incident, is, involve, immediate, incident,, investigation,, investigation, involved, in, incident., issued, instructions, investigations, incidents,, in))
(y,CompactBuffer(yield))
(b,CompactBuffer(bomber, been, before, bunker., both, by, by, but, been, by, by, but, by, bombers,))
(A,CompactBuffer(Air, August, AGM-129, ACM, Air, Air, Air, As, Air, Air, Air, Air))
(h,CompactBuffer(heavy, have, hours., handling, had, handling, handling))
(2,CompactBuffer(2007, 29–30, 2007., 2007., 2008,, 2008,))
(I,CompactBuffer(In, In, In))
(o,CompactBuffer(occurred, on, onto, of, observers, of, of, of, of, on, of, other, of, operations, on, of, of, on, other, on, of, of, of, of))
(O,CompactBuffer(October, October))
(n,CompactBuffer(nuclear, nuclear, nuclear, nuclear, not, not, nuclear, nuclear, not, nuclear, nuclear, not, numerous, numerous, nuclear, new, nuclear, nuclear, not, nuclear, nuclear))
(3,CompactBuffer(36))
(f,CompactBuffer(from, for, for, followed, four, further, from, for, find, failures, for))
(v,CompactBuffer(variable, various))
((,CompactBuffer((USAF), (DoD)))
(S,CompactBuffer(States, Six, States, States, Spear, States, Separate, Science, States, Secretary, Staff, Strike))
(J,CompactBuffer(June))
(C,CompactBuffer(Chief, Command))
(F,CompactBuffer(Force, Force, Force, Force, Force, Force, Force, Force))
(U,CompactBuffer(United, United, United, United, USAF, USAF, USAF, USAF, USAF, USAF, United, USAF, USAF))
(r,CompactBuffer(removed, reported, remained, reported, referred, response, results, released, result,, relieved, ribbon", reported, resignations,, response, recommendations, review))
(l,CompactBuffer(loaded, loaded, levels))
(N,CompactBuffer(North))
(1,CompactBuffer(19))
(–,CompactBuffer(–, –))
(m,CompactBuffer(missiles,, mistakenly, missiles, missiles, missiles, missing,, mounted, mandatory, military, missile, missions, missiles,))
(W,CompactBuffer(W80-1, Wynne))
(c,CompactBuffer(cruise, concern, conducted, concluded, commanders, commands,, certain, cruise, concerns, committee,, creation, control))

 */