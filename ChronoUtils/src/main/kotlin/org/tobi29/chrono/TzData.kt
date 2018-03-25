/*
 * Copyright 2012-2018 Tobi29
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// GENERATED FILE, DO NOT EDIT DIRECTLY!!!
// Generation script can be found in `resources/codegen/GenTzData.kts`.
// Run `resources/codegen/codegen.sh` to update sources.

@file:Suppress("NOTHING_TO_INLINE")

package org.tobi29.chrono

import org.tobi29.stdex.ConcurrentHashMap
import org.tobi29.stdex.readOnly
import org.tobi29.stdex.toIntCaseSensitive
import org.tobi29.stdex.toLongCaseSensitive

object TzData {
    private val unknownZone = OffsetZone("?", 0)

    private val offsets: List<OffsetZone> = parseOffsets(
        "CET=W4,CEST=1S8,EST=-4Gk,CST=-5Co,EDT=-3Kg,EET=1S8,EEST=2Oc,CDT=-4Gk,-03=-2Oc,MST=-6ys,PST=-7uw,MDT=-5Co,PDT=-6ys,GMT=0,-04=-3Kg,BST=W4,WET=0,WEST=W4,AEST=9mE,AEDT=aiI,AST=-3Kg,-02=-1S8,ADT=-2Oc,+04=3Kg,+05=4Gk,AKST=-8qA,AKDT=-7uw,+06=5Co,-01=-W4,+11=aiI,NZST=beM,+07=6ys,ACST=8TC,ACDT=9PG,+00=0,NZDT=caQ,+08=7uw,IST=1S8,IDT=2Oc,NST=-3he,+12=beM,NDT=-2la,+09=8qA,IST=W4,-05=-4Gk,+03=2Oc,MSK=2Oc,+10=9mE,HST=-9mE,MSD=3Kg,HDT=-8qA,CST=-4Gk,CDT=-3Kg,-06=-5Co,+1245=bWk,+1345=cSo,CST=7uw,+13=caQ,CDT=8qA,+1030=9PG,+0330=3he,+0430=4di,MET=W4,HKT=7uw,MEST=1S8,HKST=8qA,BST=-aiI,BDT=-9mE,NZMT=aLK,BDST=1S8,CAT=1S8,NST=-3i4,YST=-8qA,WAT=W4,NDT=-2m0,+02=1S8,+14=d6U,AHST=-9mE,CAST=2Oc,AHDT=-8qA,-07=-6ys,CWT=-4Gk,+0020=jm,-0530=-59m,CPT=-4Gk,EAT=2Oc,WAST=1S8,YDT=-7uw,AMT=iU,NST=1eY,-00=0,MWT=-5Co,AWST=7uw,CMT=-40w,AWDT=8qA,KST=7Xy,-10=-9mE,JST=8qA,+0630=65q,MPT=-5Co,WEMT=1S8,LMT=-3Q8,PWT=-6ys,PPT=-6ys,+0730=71u,-0930=-8TC,-0330=-3he,KDT=8TC,+1130=aLK,LMT=2iw,+0230=2la,+0245=2zG,SAST=1S8,LMT=-fC,+0530=59m,EWT=-3Kg,EPT=-3Kg,-0430=-4di,LMT=da,+0845=8c4,HST=-9PG,SMT=-4pE,+0945=988,KST=8qA,LMT=228,NST=-aiI,JDT=9mE,SAST=2Oc,+0820=7NS,LMT=-1d,AWT=-2Oc,APT=-2Oc,LMT=1hm,+0720=6RO,HDT=-8TC,ACST=8qA,IST=59m,LMT=7A3,-11=-aiI,LMT=bOM,LMT=-aEM,SST=-aiI,IMT=1Pa,YWT=-7uw,YPT=-7uw,AST=-9mE,PMT=93,-0230=-2la,PKT=4Gk,LMT=aUw,NZST=bHO,LMT=9rm,HMT=5vW,LMT=-5nw,LMT=-6yo,LMT=-4iT,MMT=2mr,MST=3iv,MDST=4ez,KDT=9mE,LMT=-7iY,NWT=-9mE,NPT=-9mE,+01=W4,LMT=2UQ,-12=-beM,WITA=7uw,LMT=1Ko,SAST=1p6,LMT=-9R4,WMT=1ji,LMT=9ty,LMT=1O8,WEST=1S8,LMT=-46E,YDDT=-6ys,KMT=-4Nh,LMT=-7nI,LMT=-40w,LMT=6h6,BMT=6h6,LMT=2cm,JMT=2c8,IDDT=3Kg,PKST=5Co,BMT=1D2,LMT=x2,BMT=sO,LMT=Mk,RMT=Mk,NWT=-2la,NPT=-2la,LMT=-4es,LMT=-zz,MSK=3Kg,RMT=1vs,+0120=1fq,LMT=-5pk,LMT=brI,LMT=-b1Q,LMT=FC,LMT=-4Xi,SMT=6u1,LMT=arK,WIB=6ys,LMT=1X7,LMT=9cg,LMT=-4XS,CMT=-4Zi,LMT=1ji,LMT=-5ti,LMT=5t2,LMT=-4pE,WET=W4,LMT=-8qM,LMT=-3Yc,LMT=P2,LMT=d7i,LMT=-9mg,AWT=-8qA,APT=-8qA,LMT=3s4,LMT=-58Q,HMT=-58Y,PMMT=9by,LMT=-6ZQ,CET=1S8,LMT=7es,LMT=-2Us,LMT=-6Pm,EMT=-6Pm,LMT=75G,LMT=-3Kk,LMT=-4io,LMT=-6DW,LMT=5E0,LMT=-6x6,LMT=1yB,HMT=1yB,LMT=-3i4,NDDT=-1p6,LMT=-6bO,LMT=bs8,+1215=bti,LMT=-5bt,LMT=1NC,CMT=1Ni,LMT=-5lY,CEMT=2Oc,LMT=2lr,MMT=2lr,CDDT=-3Kg,LMT=9Ss,LMT=-44M,LMT=8as,LMT=8Py,MDDT=-4Gk,LMT=93a,LMT=-3Eg,LMT=-21u,LMT=8Es,LMT=TS,PMT=TS,LMT=-7GA,LMT=-qc,LMT=6EU,PLMT=6EK,LMT=7Ak,LMT=7Vu,LMT=9yo,LMT=5w4,MMT=50O,LST=2rw,LMT=6FK,LMT=-dre,LMT=92k,GST=9mE,ChST=9mE,LMT=-oc,DMT=-ox,IST=xx,-1130=-aLK,LMT=9VO,LMT=-4Nh,LMT=-5IE,LMT=2LW,LMT=-1na,LMT=60n,RMT=60n,LMT=3E0,LMT=7sc,MMT=7sc,LMT=-75e,LMT=-644,LMT=-4Cu,LMT=3du,LMT=6u1,LMT=5kg,+0545=5nS,LMT=77Y,LMT=3d6,TMT=3d6,LMT=5B2,TMT=1xO,ADDT=-1S8,LMT=25a,LMT=8IX,LMT=-3v6,LMT=38A,LMT=-5zi,LMT=6Pe,PMT=6Pe,LMT=6T6,LMT=-9Ys,-1030=-9PG,LMT=-5Eo,LMT=-5vq,LMT=-5o0,MMT=-5o4,LMT=-5rR,LMT=2Mg,LMT=gW,BMT=gW,LMT=-5rC,LMT=-4ms,LMT=-3vq,LMT=nO,LMT=2c8,+0220=2bu,LMT=-4rm,LMT=4bf,LMT=4NS,LMT=-30A,LMT=5aY,LMT=-45e,LMT=Dq,LMT=-aGQ,LMT=9bG,LMT=3sI,LMT=8oA,CEST=2Oc,LMT=-3vu,MMT=-3vu,LMT=14c,+0130=1p6,LMT=4by,LMT=75e,LMT=1D2,LMT=5iT,LMT=Uc,LMT=-9kY,LMT=-4jW,LMT=-3eg,LMT=3AA,LMT=-7vq,LMT=bO,LMT=7Q8,LMT=2Sm,LMT=btC,LMT=-kI,LMT=79e,LMT=4A2,LMT=-3IN,BMT=-3IN,LMT=-1t2,LMT=3MJ,PMT=3vP,LMT=8ME,+0930=8TC,WIT=8qA,LMT=4ik,LMT=-3Da,-0345=-3vK,LMT=-4Z2,QMT=-4TS,LMT=-3Os,FFMT=-3Os,LMT=PK,LMT=-47T,LMT=17S,SET=Wi,LMT=1bS,LMT=82Q,LMT=2dq,LMT=9Ic,LMT=q4,LMT=4wk,LMT=-3gA,LMT=86e,LMT=-5AQ,LMT=93,LMT=Wg,LMT=baE,LMT=-5U4,LMT=4Aw,MMT=4Aw,LMT=3cM,LMT=-aGg,LMT=e5d,LMT=-8ol,LMT=-5ji,LMT=4kf,LMT=6Fq,BMT=6Fq,LMT=-kA,LMT=5ec,LMT=-2b6,LMT=-6Jq,LMT=ege,LMT=-8dk,LMT=-3ry,PMT=-3rK,PMT=-3ru,LMT=280,SMT=27C,LMT=1sg,LMT=-5sP,LMT=37S,LMT=6Be,LMT=-8qo,-09=-8qA,PDDT=-5Co,EDDT=-2Oc,LMT=bbK,LMT=-42M,LMT=7QM,LMT=29q,LMT=45q,LMT=dKF,LMT=-8IT,LMT=MI,CMT=MI,LMT=-1Bm,HMT=-1MQ,LMT=11f,LMT=-87y,-0830=-7Xy,-08=-7uw,LMT=aq8,LMT=1eM,LMT=1vs,LMT=-3pK,LMT=-3Be,AMT=-3Be,LMT=-7fP,LMT=8YU,LMT=aoY,LMT=-42W,LMT=-5fn,SJMT=-5fn,LMT=-8HG,LMT=iU,LMT=-6lZ,LMT=-Q,LMT=-2eg,LMT=bKM,LMT=-aIM,LMT=-aBK,-1120=-aC4,LMT=-6gk,LMT=-4Pw,LMT=4EM,LMT=-3BW,SMT=-3BW,LMT=3sE,LMT=3zi,LMT=e1N,LMT=-8rL,LMT=8ev,LMT=-5is,LMT=-P6,LMT=-8I0,LMT=-6k8,BMT=2LS,LMT=-5pR,LMT=-6wc,LMT=-6CE,LMT=5IM,LMT=2gw,LMT=-48Q,LMT=36Y,LMT=-4go,LMT=-4fO,CMT=-4fO,BST=-3jK,LMT=-eVa,LMT=7yo,LMT=-13q,FMT=-13q,LMT=-5zu,LMT=1ok,LMT=-5of,LMT=-4qw,LMT=-7h2,LMT=5S,LMT=-9P2,-1040=-9Zm,LMT=-6f6,LMT=-3z6,LMT=-2hq,LMT=5ry,LMT=-XC,LMT=avy,LMT=-4CI,BMT=-4CI,LMT=-5t9,LMT=auc,+1112=auk,+1230=bHO,LMT=36o,LMT=aNK,LMT=5Ns,LMT=-4mA,SDMT=-4mY,LMT=1II,MMT=1Is,LMT=-tm,LMT=-3K4,LMT=1U8,KMT=1U8,LMT=9pK,LMT=-4w0,PPMT=-4vG,LMT=-5vG,LMT=1A0,KMT=1uw,LMT=-2p2,LMT=-6Vy,LMT=-5pS,LMT=aaU,LMT=-4Og,LMT=-4OE,LMT=-eg,LMT=-6zq,LMT=7aQ,LMT=4Z6,MMT=4Ze,LMT=-1ag,LMT=-4ig,LMT=-4aM,LMT=-3Zm,LMT=8Uo,LMT=-1n2,LMT=9U8,LMT=c9g,LMT=-aki,LMT=1xO,LMT=21W,LMT=-Yk,LMT=300,LMT=1Yo,LMT=-3pq,LMT=-31G,LMT=-2p6,LMT=-3LS,LMT=aok,LMT=2Np,TBMT=2Np,LMT=-4he,LMT=-5pf,LMT=-3MQ,LMT=3f2,LMT=6lE,LMT=8sJ,LMT=27q,LMT=-44s,LMT=4jS,LMT=63a,LMT=bxu,+1220=by8,LMT=31m,LMT=-5AU,LMT=-7EX,LMT=-4b6,CMT=-4b2,LMT=2bR,LMT=-FK,MMT=-FK,MMT=-H4,LMT=8Wq,LMT=9B2,LMT=-6kz,LMT=b52,LMT=6vD,IMT=6vD,LMT=2f6,LMT=9iI,LMT=aGI,LMT=9Za,LMT=1tO,AMT=1tO,LMT=sA"
    )

    private val _tzdata = ConcurrentHashMap<String, TimeZone>()
    internal val tzdata = _tzdata.readOnly()

    init {
        insert(
            "Asia/Aden",
            "2E,-MHwpm=J"
        )

        insert(
            "America/Cuiaba",
            "4X,-1VB2BC=e,BUMJC=8,13r1u=e,1556w=8,13eQE=e,zB4oE=8,NiOA=e,1l18A=8,HQJi=e,1qtdS=8,IdcQ=e,1qtdS=8,wBXi=e,n0yiY=8,u4Cs=e,1XP4k=8,lnbi=e,1qPHq=8,wBXi=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,BK7iU=8,McrS=e,1jdGU=8,EArm=e,1tJvO=8,C36w=e,1tn2g=8,C36w=e,1vUn6=8,H7Mc=e,1tn2g=8,H7Mc=e,1qPHq=8,EArm=e,1vUn6=8,zvLG=e,1vUn6=8,JF72=e,1oimA=8,JF72=e,1oimA=8,H7Mc=e,1oimA=8,McrS=e,1m7vi=8,QUE0=e,1jdGU=8,McrS=e,1jdGU=8,Rh7y=e,1jdGU=8,McrS=e,1oimA=8,JF72=e,1vUn6=8,C36w=e,3EANO=8,DRug=e,1oimA=8,JF72=e,1vUn6=8,EArm=e,1lL1K=8,JF72=e,1qPHq=8,H7Mc=e,1qPHq=8,JF72=e,1oimA=8,JF72=e,1oimA=8,McrS=e,1oimA=8,H7Mc=e,1qPHq=8,H7Mc=e,1qPHq=8,JF72=e,1oimA=8,JF72=e,1oimA=8,JF72=e,1oimA=8,JF72=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,EArm=e,1vUn6=8,C36w=e,1vUn6=8,EArm=e,1tn2g=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,EArm=e,1tn2g=8,EArm=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1yrHW=8,C36w=e,1vUn6=8,EArm=e,1tn2g=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,EArm=e,1tn2g=8,EArm=e,1vUn6=8"
        )

        insert(
            "Etc/GMT+9",
            "-1,"
        )

        link("Etc/GMT+8", "Etc/GMT+9")

        insert(
            "Africa/Nairobi",
            "1L,-1qDySw=1n,3d18o=1M,llWXK=1N,GIfes=1n"
        )

        insert(
            "America/Marigot",
            "1D,-1ZvVA0=k"
        )

        insert(
            "Asia/Aqtau",
            "4Y,-1zwYBG=n,d6pqg=o,1Lw5xe=r,13XNK=r,14ldm=o,13ZFS=r,14khi=o,14m9q=r,140BW=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,16w4E=o,13YJO=o,13ZFS=n,EBnq=o,pmqk=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=n,13ZFS=o,13YJO=n,16w4E=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=o"
        )

        insert(
            "Pacific/Kwajalein",
            "3h,-2nmxoc=t,2mP1f2=2F,P11hC=E"
        )

        insert(
            "America/El_Salvador",
            "4Z,-1GE1Uc=3,2hFgNq=7,Rh7y=3,1gGm4=7,Rh7y=3"
        )

        insert(
            "Asia/Pontianak",
            "50,-27HZWE=51,QkBs4=1G,jJSL6=G,7NdSU=1G,5yMDC=A,4gDri=1G,tc648=2G,PfTi8=3i"
        )

        insert(
            "Africa/Cairo",
            "3j,-2nTKK1=5,1mYdQ9=6,sgeI=5,194ly=6,TOso=5,19qP6=6,1dKFy=5,UzhC=6,1fz3i=5,T7nq=6,1fz3i=5,Yc36=6,1a7U4=5,oBwpG=6,QbGU=5,1eRYk=6,TrYQ=5,1eSUo=6,T7nq=5,1fz3i=6,T7nq=5,1fczK=6,T7nq=5,1fczK=6,T7nq=5,1fczK=6,T7nq=5,1fz3i=6,T7nq=5,1fczK=6,T7nq=5,1fczK=6,TtQY=5,1eQ6c=6,TtQY=5,1fczK=6,TtQY=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1fczK=6,TtQY=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1fczK=6,TtQY=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1fczK=6,TtQY=5,1eQ6c=6,TtQY=5,1JEBO=6,oFlm=5,1EWpG=6,tnxu=5,1fczK=6,TtQY=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1fczK=6,TtQY=5,1gEtW=6,RFte=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1fczK=6,TtQY=5,1eQ6c=6,TtQY=5,1eQ6c=6,TtQY=5,1dJJu=6,TOso=5,1e91e=6,TOso=5,1e91e=6,TOso=5,1e91e=6,TOso=5,1gGm4=6,TOso=5,1e91e=6,TOso=5,1e91e=6,TOso=5,1e91e=6,TOso=5,1e91e=6,TOso=5,1gGm4=6,TOso=5,1e91e=6,TOso=5,1e91e=6,Rh7y=5,1gGm4=6,McrS=5,1lL1K=6,JF72=5,1oimA=6,H7Mc=5,1tn2g=6,Bk9q=5,aTew=6,7B4s=5,7JDsA=6,fd4Y=5,cHCg=6,khKE=5"
        )

        insert(
            "Pacific/Pago_Pago",
            "2f,-2FuKEM=2g,DuuRO=2h"
        )

        insert(
            "Africa/Mbabane",
            "2H,-2Gmf7y=2I,nBSNG=1O,1mtN8c=23,13XNK=1O,13ZFS=23,13XNK=1O"
        )

        insert(
            "Asia/Kuching",
            "52,-1vCRZS=1G,eBAnu=A,5LrrG=24,wZ3y=A,1BHna=24,wZ3y=A,1BkTC=24,wZ3y=A,1BkTC=24,wZ3y=A,1BkTC=24,wZ3y=A,1BHna=24,wZ3y=A,1BkTC=24,wZ3y=A,ncOs=G,7CIx2=A"
        )

        insert(
            "Pacific/Rarotonga",
            "53,-2nmcY0=54,2GhRvO=1H,EArm=1y,1ohTy=1H,JFA4=1y,1ohTy=1H,JFA4=1y,1ohTy=1H,McUU=1y,1ohTy=1H,JFA4=1y,1ohTy=1H,JFA4=1y,1ohTy=1H,JFA4=1y,1ohTy=1H,JFA4=1y,1ohTy=1H,JFA4=1y,1ohTy=1H,McUU=1y,1ohTy=1H,JFA4=1y,1ohTy=1H,JFA4=1y,1ohTy=1H,JFA4=1y"
        )

        insert(
            "Pacific/Honolulu",
            "2J,-2xXEno=1W,1hDOcy=2a,7Kr6=1W,iCRYA=2a,7LMrK=1W,3BkvS=M"
        )

        insert(
            "America/Guatemala",
            "55,-1LqW9e=3,1TLgqw=7,wYqQ=3,jIOsM=7,IW9W=3,g0Yj6=7,YT84=3,vhaco=7,TOso=3"
        )

        insert(
            "Australia/Hobart",
            "3k,-2yKIwY=i,J1tqk=j,11qsU=i,QU95S=j,vwwE=i,13ZFS=j,13XNK=i,16x0I=j,11qsU=i,OdKla=j,13YJO=i,1e85a=j,MdnW=i,1lK5G=j,MdnW=i,1lK5G=j,OKIM=i,1lK5G=j,H8Ig=i,1qOLm=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,MdnW=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,TPos=i,1gFq0=j,Ri3C=i,1gFq0=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1lK5G=j,Ri3C=i,1jcKQ=j,Ri3C=i,1jcKQ=j,OKIM=i,1jcKQ=j,OKIM=i,1jcKQ=j,TPos=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,13YJO=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,TPos=j,1e85a=i,193pu=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,13YJO=i,13YJO=j,11roY=i,193pu=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,16w4E=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j"
        )

        insert(
            "Europe/London",
            "25,-4cJnsV=d,2me4kZ=f,MdnW=d,16w4E=f,WJcQ=d,169B6=f,16Syc=d,13Cgg=f,14ldm=d,13Cgg=f,1euyI=d,W0fK=f,14ldm=d,114Vq=f,193pu=d,193pu=f,Ri3C=d,1e85a=f,WmJi=d,1e85a=f,YU48=d,193pu=f,YU48=d,16w4E=f,11roY=d,1bAKk=f,YU48=d,193pu=f,YU48=d,16w4E=f,11roY=d,193pu=f,YU48=d,193pu=f,YU48=d,16w4E=f,13YJO=d,193pu=f,YU48=d,16w4E=f,11roY=d,193pu=f,YU48=d,193pu=f,YU48=d,16w4E=f,11roY=d,193pu=f,1gFq0=d,zwHK=f,2xjTW=17,zwHK=f,1ohqw=17,JG36=f,1ohqw=17,MdnW=f,1lK5G=17,YU48=f,19pT2=17,BHz2=f,usY8=d,16w4E=f,11roY=d,WmJi=f,a8pi=17,H8Ig=f,usY8=d,MdnW=f,1lK5G=d,TPos=f,1e85a=d,YU48=f,16w4E=d,11roY=f,16w4E=d,13YJO=f,16w4E=d,11roY=f,YU48=d,16w4E=f,11roY=d,193pu=f,YU48=d,1bAKk=f,YU48=d,16w4E=f,11roY=d,193pu=f,YU48=d,193pu=f,YU48=d,16w4E=f,11roY=d,11roY=f,1gFq0=d,Ri3C=f,1gFq0=d,TPos=f,1e85a=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1jcKQ=d,EBnq=f,1tji0=f,6qszS=d,OKIM=f,1jcKQ=d,OKIM=f,1jcKQ=d,OKIM=f,1jcKQ=d,OKIM=f,1jcKQ=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1jcKQ=d,OKIM=f,1jcKQ=d,OKIM=f,1jcKQ=d,TOso=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d,Ri3C=f,1gFq0=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1e85a=d,WmJi=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,Ri3C=f,1gFq0=d,TPos=f,1e85a=d,TPos=f,1e85a=d,TPos=f,1gFq0=d"
        )

        insert(
            "America/Panama",
            "3l,-2KQyqs=3m,D5u0o=2"
        )

        insert(
            "America/Belize",
            "56,-1Zl1Cg=3,dUrUA=1l,JFA4=3,1ohTy=1l,McUU=3,1lKyI=1l,McUU=3,1lKyI=1l,McUU=3,1ohTy=1l,JFA4=3,1ohTy=1l,JFA4=3,1ohTy=1l,McUU=3,1lKyI=1l,McUU=3,1lKyI=1l,McUU=3,1lKyI=1l,McUU=3,1ohTy=1l,JFA4=3,1ohTy=1l,JFA4=3,1ohTy=1l,McUU=3,1lKyI=1l,McUU=3,1lKyI=1l,McUU=3,1ohTy=1l,JFA4=3,1ohTy=1l,JFA4=3,1ohTy=1l,JFA4=3,1ohTy=1l,McUU=3,1lKyI=1l,McUU=3,1lKyI=1l,McUU=3,1ohTy=1l,JFA4=3,1ohTy=1l,JFA4=3,1ohTy=1l,McUU=3,1lKyI=1l,McUU=3,13N91u=7,nUw8=3,iUqdy=7,khKE=3"
        )

        insert(
            "Asia/Chungking",
            "2d,-2nmuwv=U,1mbDZd=W,HufK=U,Yc36=W,1a7U4=U,1xe6D6=W,McrS=U,1e91e=W,TOso=U,1e91e=W,TOso=U,1gGm4=W,TOso=U,1e91e=W,TOso=U,1e91e=W,TOso=U"
        )

        insert(
            "America/Managua",
            "57,-2KQy0k=58,1wYvcw=3,1kYXX2=2,3PNHG=3,8IxwI=7,zSfe=3,1y5eo=7,zSfe=3,oBWDu=2,1yIz6=3,zU7m=2,8xDm8=3,hFcHK=7,11qsU=3,1eaTm=7,TNwk=3"
        )

        insert(
            "America/Indiana/Petersburg",
            "59,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,ksP7i=7,RiZG=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=2,3esCc=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,pois=7,1Izba=3,H9Ek=7,1qNPi=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=2,YHnrO=7,1e85a=3,Mek0=7,1ogus=2,JG36=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "Asia/Yerevan",
            "5a,-1zwYfm=J,1872IM=n,Pr7B6=o,14khi=n,13ZFS=o,14khi=n,13ZFS=o,14khi=n,14m9q=o,140BW=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,16w4E=n,13YJO=n,13ZFS=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=n,3esCc=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n"
        )

        insert(
            "Europe/Brussels",
            "5b,-36cWDw=5c,qkZMI=g,M5AXE=0,39Kq4=1,TsUU=0,19rLa=1,TPos=0,1e85a=1,TPos=0,ks3m=g,E3F6=h,1gFq0=g,MdnW=h,1tm6c=g,PtFS=h,1jzeo=g,SJXO=h,193pu=g,193pu=h,YU48=g,11roY=h,16w4E=g,13YJO=h,13YJO=g,193pu=h,YU48=g,16w4E=h,11roY=g,193pu=h,11uda=g,193pu=h,YU48=g,16w4E=h,11roY=g,193pu=h,YU48=g,13YJO=h,13YJO=g,11roY=h,193pu=g,13YJO=h,13YJO=g,11roY=h,16w4E=g,193pu=h,YU48=g,13YJO=h,13YJO=g,11roY=h,16w4E=g,193pu=h,1gFq0=g,zwHK=h,uOvC=1,5eO5i=0,Ri3C=1,16w4E=0,13YJO=1,YxAA=0,19pT2=1,YxAA=0,1qOLm=1,P7ck=0,1375gQ=1,11roY=0,16w4E=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        link("GMT", "Etc/GMT+9")

        insert(
            "Europe/Warsaw",
            "3n,-36cXFS=2K,1e0t9u=0,1zS7e=1,TtQY=0,19rLa=1,TPos=0,1e85a=1,TPos=5,1etCE=6,TPos=5,5Mvte=0,CzCQU=1,52uOI=0,Ri3C=1,16w4E=0,13YJO=1,14GKQ=0,1d1Is=1,15pHW=0,Xt60=1,11PKE=0,1dLBC=1,TPos=0,193pu=1,YU48=0,16w4E=1,11roY=0,gn3vq=1,H8Ig=0,13YJO=1,13YJO=0,1qOLm=1,JG36=0,13YJO=1,13YJO=0,1ohqw=1,JG36=0,1ohqw=1,JG36=0,1ohqw=1,JG36=0,1qOLm=1,H8Ig=0,qJ6tG=1,11roY=0,16w4E=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13ZFS=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "America/Chicago",
            "3o,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,1lL1K=7,OJMI=3,RiZG=7,1gEtW=3,13ZFS=7,Rh7y=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,Rh7y=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,TQkw=2,1vSuY=3,WnFm=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,Rh7y=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,MANy=1j,7uZ20=1m,gNpK=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,Rh7y=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,pois=7,1Izba=3,H9Ek=7,1qNPi=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        insert(
            "Asia/Kashgar",
            "3p,-1rHAMQ=r"
        )

        insert(
            "Chile/Continental",
            "3q,-2KQyYG=1X,GL9hm=I,dP0V4=1X,4GntA=e,1IzrQ=1X,hrMNM=e,1fcQq=I,TtQY=e,1eQ6c=I,TtQY=e,1eQ6c=I,TtQY=e,1eQ6c=I,TtQY=e,1fczK=I,TtQY=e,kOzIc=I,m80w=e,8rtfO=8,hnWg=e,1eRYk=I,iuiY=e,JOKxa=8,Rh7y=e,1oimA=8,JF72=e,194ly=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1bBGo=8,WlNe=e,1gGm4=8,Rh7y=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,13XNK=e,13ZFS=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,16x0I=8,11qsU=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,YT84=e,194ly=8,TOso=e,194ly=8,16v8A=e,16x0I=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,YT84=e,194ly=8,TOso=e,1e91e=8,11qsU=e,16x0I=8,1e796=e,C4YE=8,1tla8=e,JGZa=8,1ogus=e,Mek0=8,1lJ9C=e,Mek0=8,3BiDK=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,zxDO=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,zxDO=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,zxDO=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,x0iY=8,1AXaE=e,zxDO=8"
        )

        insert(
            "Pacific/Yap",
            "2L,-2nmwq0=L"
        )

        insert(
            "CET",
            "0,-1QCCpa=1,TtQY=0,19rLa=1,TPos=0,1e85a=1,TPos=0,K0lMI=1,5wAne=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,YxAA=0,15n1ew=1,11roY=0,16w4E=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        link("Etc/GMT-1", "Etc/GMT+9")

        link("Etc/GMT-0", "Etc/GMT+9")

        link("Europe/Jersey", "Europe/London")

        insert(
            "America/Tegucigalpa",
            "5d,-1G7p8w=3,2h8E1K=7,Rh7y=3,1gGm4=7,Rh7y=3,BC8OQ=7,xkUo=3"
        )

        link("Etc/GMT-5", "Etc/GMT+9")

        insert(
            "Europe/Istanbul",
            "2M,-36cYaI=2i,13Fa3m=5,bVbIc=6,TrYQ=5,7rS6I=6,1etCE=5,W1bO=6,14khi=5,115Ru=6,192tq=5,3pmMM=6,P6gg=5,1eRYk=6,TrYQ=5,vuzPG=6,z9i8=5,kG6k=6,1Izba=5,17Crm=6,1fz3i=5,5a7Li=6,16v8A=5,1nzpu=6,IdcQ=5,1aSJi=6,YT84=5,194ly=6,YT84=5,16x0I=6,11qsU=5,1a9Mc=6,10l2g=5,194ly=6,ZfBC=5,mZPlS=6,uNzy=5,3q5JS=6,Onja=5,bVzaM=6,TOso=5,1e91e=6,TOso=5,1gGm4=6,TOso=5,1ojiE=6,TQkw=5,Ri3C=6,1gHi8=5,Rejm=6,1e796=5,1hpja=6,T5vi=5,TQkw=6,192tq=5,YV0c=6,192tq=n,28j16=J,118FG=n,16ONW=J,YBkQ=n,19m8M=J,YBkQ=n,19m8M=J,1IezK=n,mP5u=J,3jcGs=6,WmJi=5,14n5u=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,11roY=6,16w4E=5,13YJO=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,RjVK=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,RExa=6,1giWs=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,UbS0=6,1dLBC=5,TPos=6,1jcKQ=5,OKIM=6,XopG=J"
        )

        insert(
            "America/Eirunepe",
            "5e,-1VB1Kg=I,BUMOk=e,13r1u=I,1556w=e,13eQE=I,zB4oE=e,NiOA=I,1l18A=e,HQJi=I,1qtdS=e,IdcQ=I,1qtdS=e,wBXi=I,n0yiY=e,u4Cs=I,1XP4k=e,lnbi=I,1qPHq=e,wBXi=I,1qPHq=e,HufK=I,1qPHq=e,HQJi=I,BK7iU=e,McrS=I,1jdGU=e,EArm=I,1tJvO=e,C36w=I,c9HLa=e,JF72=I,uCViw=e,bulyw=I"
        )

        link("Etc/GMT-4", "Etc/GMT+9")

        insert(
            "America/Miquelon",
            "5f,-21dN4Q=k,2nhEZa=8,eNcHu=l,1bzOg=8,WnFm=l,1e796=8,TQkw=l,1e796=8,TQkw=l,1e796=8,WnFm=l,1bzOg=8,WnFm=l,1bzOg=8,WnFm=l,1e796=8,TQkw=l,1e796=8,TQkw=l,1e796=8,WnFm=l,1bzOg=8,WnFm=l,1bzOg=8,WnFm=l,1bzOg=8,WnFm=l,1e796=8,TQkw=l,1e796=8,TQkw=l,1e796=8,WnFm=l,1bzOg=8,WnFm=l,1bzOg=8,WnFm=l,1e796=8,TQkw=l,1e796=8,TQkw=l,1e796=8,Mek0=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,Mek0=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,Mek0=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,Mek0=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,Mek0=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,Mek0=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,JGZa=l,1ogus=8,Mek0=l,1ogus=8"
        )

        link("Etc/GMT-3", "Etc/GMT+9")

        insert(
            "Europe/Luxembourg",
            "5g,-2g4j1q=0,pwLhW=1,Opbi=0,1e796=1,P88o=0,1e9Xi=1,TPos=0,plug=g,zaec=h,1gIec=g,MazK=h,1tnYk=g,PrNK=h,1jB6w=g,SI5G=h,194ly=g,192tq=h,YVWg=g,11pwQ=h,16x0I=g,14khi=h,13Dck=g,192tq=h,YV0c=g,16v8A=h,11sl2=g,192tq=h,11sl2=g,192tq=h,YWSk=g,16w4E=h,11roY=g,193pu=h,YU48=g,13YJO=h,13YJO=g,11roY=h,193pu=g,13YJO=h,13YJO=g,11roY=h,16w4E=g,193pu=h,YU48=g,13YJO=h,13YJO=g,11roY=h,16w4E=g,193pu=h,1gFq0=g,zwHK=h,sDEk=2N,5gYWA=3r,Ri3C=2N,16w4E=3r,13YJO=2N,YU48=0,193pu=1,YxAA=0,1qOLm=1,P7ck=0,1375gQ=1,11roY=0,16w4E=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        link("Etc/GMT-2", "Etc/GMT+9")

        link("Etc/GMT-9", "Etc/GMT+9")

        insert(
            "America/Argentina/Catamarca",
            "2O,-2Ax4Ak=1v,Sscm0=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=8,1lL1K=l,McrS=e,1lLXO=l,MbvO=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,94hby=e,6TZu=8,7wUUg=l,rTLa=8"
        )

        link("Etc/GMT-8", "Etc/GMT+9")

        link("Etc/GMT-7", "Etc/GMT+9")

        link("Etc/GMT-6", "Etc/GMT+9")

        insert(
            "Europe/Zaporozhye",
            "5h,-36cYyI=5i,1wG0U8=5,d6qli=K,nSaY0=1,2xoAg=0,Ri3C=1,16w4E=0,7A8o=K,1hWMuY=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,16w4E=K,13YJO=6,13WRG=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,142u4=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        insert(
            "Canada/Yukon",
            "3s,-2o8Ona=1a,BGRWQ=1p,192tq=1a,1e91e=1p,VXry=1a,LzyjS=2j,7uWdO=2k,gQdW=1a,FMXeg=2P,16w4E=1a,3m5yM=a,rAptm=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a"
        )

        insert(
            "Canada/Atlantic",
            "3t,-2kganC=k,tsLio=m,14khi=k,3h3Hi=m,192tq=k,3gZX2=m,EArm=k,1sE5a=m,IdcQ=k,1nVT2=m,Ko48=k,1q6Kk=m,HQJi=k,1q6Kk=m,MyVq=k,1loyc=m,RDB6=k,1loyc=m,HufK=k,1loyc=m,RDB6=k,1loyc=m,H7Mc=k,1qPHq=m,Fjos=k,1sE5a=m,K1AA=k,1nVT2=m,P6gg=k,1gjSw=m,RDB6=k,1gjSw=m,UaVW=k,1loyc=m,H7Mc=k,1vUn6=m,HufK=k,1qPHq=m,C36w=k,1loyc=m,RDB6=k,1gjSw=m,RDB6=k,1qtdS=m,HufK=k,1iRdm=m,RDB6=k,1gjSw=m,RDB6=k,Mgc8=26,7v0U8=27,gLxC=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,3oDPG=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,3oDPG=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,5wBji=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k"
        )

        insert(
            "Atlantic/St_Helena",
            "1P,-1ZS6eY=d"
        )

        link("Australia/Tasmania", "Australia/Hobart")

        insert(
            "Libya",
            "3u,-1IMOJe=0,15SAsk=1,sAQ8=0,3MBa0=1,updS=0,3IWwo=1,xHnW=0,6plh6=5,N7yRW=0,wDPq=1,14khi=0,13ZFS=1,14khi=0,14m9q=1,14khi=0,15O3C=1,12vTy=0,1556w=1,13XNK=0,13gIM=1,14khi=0,14m9q=1,14khi=0,13ZFS=1,14khi=0,1fXoY=5,dGEKI=0,15rA4=1,14khi=5,wfIJ2=0,Oofe=1,1e85a=5"
        )

        link("Europe/Guernsey", "Europe/London")

        insert(
            "America/Grand_Turk",
            "5j,-2KQyWY=2Q,L9M1F=2,2jBig1=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=k,529he=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "US/Pacific-New",
            "2R,-2XUWje=a,1bnUha=c,1e796=a,TQkw=c,1e796=a,LBHj2=1E,7uX9S=1F,gPhS=a,5ePYo=c,1IcGE=a,2PsFq=c,Ri3C=a,1gFq0=c,TPos=a,1e85a=c,TPos=a,1e85a=c,TPos=a,1e85a=c,TPos=a,1e85a=c,TPos=a,1gFq0=c,TPos=a,1e85a=c,TPos=a,1e85a=c,TPos=a,1e85a=c,TPos=a,1e85a=c,TPos=a,1gFq0=c,Ri3C=a,1gFq0=c,13YJO=a,13YJO=c,13YJO=a,13YJO=c,13YJO=a,13YJO=c,16w4E=a,11roY=c,16w4E=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,pois=c,1Izba=a,H9Ek=c,1qNPi=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a"
        )

        insert(
            "Asia/Samarkand",
            "5k,-1zwZEl=n,d6qsV=o,1KrKjS=r,14khi=r,13YJO=r,14ldm=o,13ZFS=r,14khi=o,14m9q=r,140BW=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,16w4E=o,13YJO=r,13YJO=o"
        )

        insert(
            "America/Argentina/Cordoba",
            "2S,-2Ax4Gs=1v,Sscs8=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=8,1lL1K=l,McrS=e,1lLXO=l,MbvO=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,gI65i=l,rTLa=8,1gGm4=l,Rh7y=8"
        )

        insert(
            "Asia/Phnom_Penh",
            "2T,-36d2DG=2U,1nX7Pi=v"
        )

        insert(
            "Africa/Kigali",
            "20,-2iKmWU=18"
        )

        insert(
            "Asia/Almaty",
            "5l,-1zx0gY=o,d6q9u=r,1KrKjS=v,14khi=r,13ZFS=v,14khi=r,13ZFS=v,14khi=r,14m9q=v,140BW=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,16w4E=r,13YJO=r,13ZFS=o,EBnq=r,pmqk=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,16w4E=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r"
        )

        insert(
            "US/Alaska",
            "3v,-3wgI1x=3w,1885OD=2l,1qznYI=3x,7uVhK=3y,gRa0=2l,JUTHq=1f,4qsEg=1h,13XNK=1f,13ZFS=1h,13XNK=1f,13ZFS=1h,16v8A=1f,13ZFS=1h,13XNK=1f,13ZFS=1h,13XNK=1f,pois=1h,1Izba=1f,H9Ek=1h,1qNPi=1f,13ZFS=1h,16v8A=1f,11sl2=1h,16v8A=1f,13ZFS=1h,13XNK=1f,13ZFS=1h,13XNK=1f,13ZFS=1h,13XNK=1f,13ZFS=1h,13XNK=1f,13ZFS=1h,16v8A=1f,11sl2=1h,16v8A=1a,bcTS=p,SLPW=q,13XNK=p,13ZFS=q,13XNK=p,13ZFS=q,13XNK=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p"
        )

        insert(
            "Asia/Dubai",
            "3z,-1IMRmg=n"
        )

        link("Europe/Isle_of_Man", "Europe/London")

        insert(
            "America/Araguaina",
            "5m,-1VB368=8,BUMi4=l,13r1u=8,1556w=l,13eQE=8,zB4oE=l,NiOA=8,1l18A=l,HQJi=8,1qtdS=l,IdcQ=8,1qtdS=l,wBXi=8,n0yiY=l,u4Cs=8,1XP4k=l,lnbi=8,1qPHq=l,wBXi=8,1qPHq=l,HufK=8,1qPHq=l,HQJi=8,BK7iU=l,McrS=8,1jdGU=l,EArm=8,1tJvO=l,C36w=8,1tn2g=l,C36w=8,1vUn6=l,H7Mc=8,c7aqk=l,H7Mc=8,1oimA=l,McrS=8,1m7vi=l,QUE0=8,1jdGU=l,McrS=8,1jdGU=l,Rh7y=8,1jdGU=l,McrS=8,1oimA=l,JF72=8,1vUn6=l,C36w=8,kFxFC=l,H7Mc=8"
        )

        insert(
            "Cuba",
            "3A,-2KQyfu=3B,1dUui4=P,6b03e=Q,IdcQ=P,oRPRm=Q,wYqQ=P,1AZ2M=Q,zvLG=P,1AZ2M=Q,wYqQ=P,5QU00=Q,wYqQ=P,1AZ2M=Q,wYqQ=P,E2ABq=Q,HQJi=P,1pnNe=Q,JF72=P,16axa=Q,UaVW=P,1gGm4=Q,Rh7y=P,1lL1K=Q,13XNK=P,13ZFS=Q,13XNK=P,13ZFS=Q,16v8A=P,13ZFS=Q,WlNe=P,1bBGo=Q,WIgM=P,1bfcQ=Q,X4Kk=P,1aSJi=Q,13XNK=P,13ZFS=Q,16v8A=P,11sl2=Q,16v8A=P,16x0I=Q,TOso=P,WnFm=Q,1e796=P,TQkw=Q,1e796=P,1e91e=Q,TOso=P,1e91e=Q,TOso=P,1e91e=Q,TOso=P,1e91e=Q,WlNe=P,1bBGo=Q,WlNe=P,TQkw=Q,1e796=P,TQkw=Q,1e796=P,WnFm=Q,1bzOg=P,WnFm=Q,1bzOg=P,11sl2=Q,192tq=P,11sl2=Q,16w4E=P,11roY=Q,16w4E=P,11roY=Q,16w4E=P,11roY=Q,16w4E=P,11roY=Q,16w4E=P,13YJO=Q,13YJO=P,13YJO=Q,16w4E=P,YU48=Q,1e85a=P,TPos=Q,1gFq0=P,TPos=Q,1e85a=P,TPos=Q,1e85a=P,WmJi=Q,1bAKk=P,WmJi=Q,1bAKk=P,TPos=Q,5wAne=P,MdnW=Q,1lK5G=P,OKIM=Q,1jcKQ=P,MdnW=Q,1lK5G=P,OKIM=Q,1lK5G=P,OKIM=Q,1ohqw=P,OKIM=Q,1gFq0=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,MdnW=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,MdnW=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,MdnW=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,MdnW=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,JG36=Q,1ohqw=P,MdnW=Q,1ohqw=P"
        )

        insert(
            "Asia/Novosibirsk",
            "5n,-1ITk2E=r,msIZ6=v,1KrKjS=A,14khi=v,13ZFS=A,14khi=v,13ZFS=A,14khi=v,14m9q=A,140BW=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,16w4E=v,13YJO=v,13ZFS=r,EBnq=v,pmqk=A,13YJO=v,13YJO=A,kfSw=v,JJNm=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,16w4E=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,7EwUM=r,3IWwo=v"
        )

        insert(
            "America/Argentina/Salta",
            "5o,-2Ax4BK=1v,Sscnq=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=8,1lL1K=l,McrS=e,1lLXO=l,MbvO=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,gI65i=l,rTLa=8"
        )

        link("Etc/GMT+3", "Etc/GMT+9")

        insert(
            "Africa/Tunis",
            "5p,-33iM8s=2m,11Hmqv=0,Y0zu1=1,1gFq0=0,zTbi=1,3raes=0,TQkw=1,1ojiE=0,Ri3C=1,6S7m=0,2UKs=1,WIgM=0,13ZFS=1,166MU=0,11QGI=1,YuMo=0,15wP2o=1,Ri3C=0,1hon6=1,TsUU=0,kE4Pm=1,G3hC=0,13YJO=1,13YJO=0,1hon6=1,T6rm=0,v9aMg=1,T7nq=0,12bi8=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0"
        )

        link("Etc/GMT+2", "Etc/GMT+9")

        link("Etc/GMT+1", "Etc/GMT+9")

        insert(
            "Pacific/Fakaofo",
            "5q,-2nmcfC=2e,3P2Mru=V"
        )

        link("Africa/Tripoli", "Libya")

        link("Etc/GMT+0", "Etc/GMT+9")

        insert(
            "Israel",
            "2V,-36cYyW=2W,1j9uyi=B,LS08E=C,5a5Ta=B,SMM0=C,1fxba=B,T7nq=C,1fz3i=B,Yc36=C,1a9Mc=B,Yc36=C,1a61W=B,3ki76=2X,AAgg=C,m9SE=B,13Bkc=C,14ICY=B,YaaY=C,T8ju=B,19Kus=C,1jeCY=B,WmJi=C,13YJO=B,11roY=C,TPos=B,1AWeA=C,wYqQ=B,1AErm=C,xj2g=B,1yrHW=C,HaAo=B,1euyI=C,QSLS=B,zR1mM=C,zvLG=B,16x0I=C,McrS=B,kxVF6=C,TOso=B,1qPHq=C,EArm=B,1hLMI=C,SJ1K=B,1e91e=C,Rh7y=B,1oimA=C,JF72=B,1bBGo=C,TOso=B,1e91e=C,WlNe=B,1e91e=C,WlNe=B,1dq48=C,Uxpu=B,1dq48=C,S04E=B,1fXoY=C,Uxpu=B,18los=C,153eo=B,15rA4=C,129q0=B,15O3C=C,ZC5a=B,1drWg=C,TOso=B,1jdGU=C,11pwQ=B,1556w=C,YT84=B,15rA4=C,17Aze=B,10mUo=C,16v8A=B,15O3C=C,YT84=B,17gTS=C,17e5G=B,10JnW=C,14GKQ=B,13gIM=C,ZC5a=B,18los=C,17e5G=B,10JnW=C,14GKQ=B,13gIM=C,ZC5a=B,1aSJi=C,14GKQ=B,13gIM=C,129q0=B,15O3C=C,1eQ6c=B,T7nq=C,1eQ6c=B,T7nq=C,1eQ6c=B,T7nq=C,1hnr2=B,QA2A=C,1hnr2=B,QA2A=C,1hnr2=B,T7nq=C,1eQ6c=B,T7nq=C,1eQ6c=B,T7nq=C,1hnr2=B,QA2A=C,1hnr2=B,QA2A=C,1hnr2=B,T7nq=C,1eQ6c=B,T7nq=C,1eQ6c=B,T7nq=C,1eQ6c=B,T7nq=C,1hnr2=B,QA2A=C,1hnr2=B,QA2A=C,1hnr2=B,T7nq=C,1eQ6c=B,T7nq=C,1eQ6c=B,T7nq=C,1hnr2=B,QA2A=C,1hnr2=B,QA2A=C,1hnr2=B,QA2A=C,1hnr2=B,T7nq=C,1eQ6c=B,T7nq=C,1eQ6c=B,T7nq=C,1hnr2=B"
        )

        link("Africa/Banjul", "Atlantic/St_Helena")

        link("Etc/GMT+7", "Etc/GMT+9")

        link("Indian/Comoro", "Africa/Nairobi")

        link("Etc/GMT+6", "Etc/GMT+9")

        link("Etc/GMT+5", "Etc/GMT+9")

        link("Etc/GMT+4", "Etc/GMT+9")

        insert(
            "Pacific/Port_Moresby",
            "5r,-36d5yg=3C,w2hdK=L"
        )

        insert(
            "US/Arizona",
            "3D,-2XUXfi=9,1bnUha=b,1e796=9,TQkw=b,1e796=9,LBHj2=1t,42swI=9,x0iY=1t,14khi=9,MdqJe=b,13XNK=9"
        )

        insert(
            "Antarctica/Syowa",
            "1s,-rB7uo=J"
        )

        insert(
            "Indian/Reunion",
            "5s,-217JWE=n"
        )

        insert(
            "Pacific/Palau",
            "5t,-2nmvl2=G"
        )

        insert(
            "Europe/Kaliningrad",
            "28,-2DUHri=0,Ni528=1,TtQY=0,19rLa=1,TPos=0,1e85a=1,TPos=0,K0lMI=1,5wAne=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,wXuM=3E,GLiE=5u,15pHW=3E,m80w=K,1dh8DS=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=6,13ZFS=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=J,7EwUM=5"
        )

        insert(
            "America/Montevideo",
            "5v,-2sIKsQ=5w,KDRJu=1I,7iN1G=8,13YgM=1I,14lGo=8,13YgM=1I,14lGo=8,13YgM=1I,gbtEY=8,TOVq=1I,1e8yc=8,TOVq=1I,1e8yc=8,TOVq=1I,1gFT2=8,RhAA=1I,1gFT2=8,RhAA=1I,1gFT2=8,RhAA=1I,1gFT2=8,TOVq=1I,1e8yc=8,TOVq=1I,IXz2=8,TsrS=1I,21NQk=l,wBug=8,yAlWM=l,11qsU=8,mQXC=l,hKpO=8,aQv0k=l,11qsU=8,16x0I=l,1etCE=8,TtQY=l,1eQ6c=8,1dMxG=2n,16vBC=8,11Oly=2n,16vBC=8,11Oly=2n,16vBC=8,2Yx3a=l,EWUU=8,3lnxK=2n,1G2jm=l,3NgPS=8,2vxok=l,GLiE=8,3cG6A=l,1fczK=8,ggVhe=l,wYqQ=8,1ACze=l,wYqQ=8,1lL1K=l,JF72=8,1lL1K=l,McrS=8,1oimA=l,JF72=8,1lL1K=l,McrS=8,oGeBO=l,16x0I=8,194ly=l,TOso=8,1bBGo=l,WlNe=8,1e91e=l,TOso=8,1e91e=l,TOso=8,1e91e=l,WlNe=8,1bBGo=l,WlNe=8,1bBGo=l,WlNe=8,1e91e=l,TOso=8,1e91e=l,TOso=8,1e91e=l,TOso=8"
        )

        insert(
            "Africa/Windhoek",
            "5x,-2Gmerm=5y,nBS7u=1O,1mtN8c=23,13XNK=1O,1CnsD6=18,8xEic=1b,YAoM=1o,1e796=1b,TQkw=1o,1gEtW=1b,RiZG=1o,1gEtW=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1gEtW=1b,RiZG=1o,1gEtW=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1gEtW=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1gEtW=1b,RiZG=1o,1gEtW=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=1o,1e796=1b,TQkw=18"
        )

        insert(
            "Asia/Karachi",
            "5z,-2ay8Vu=1Q,1eaBx2=1A,6Fgn6=1Q,cIRZm=o,FC6kU=2o,14he6Y=2Y,13XNK=2o,c4D5u=2Y,TrYQ=2o,XPzy=2Y,1aunC=2o"
        )

        link("Africa/Mogadishu", "Africa/Nairobi")

        insert(
            "Australia/Perth",
            "3F,-2ydHcg=1u,J1NX2=1w,u6tC=1u,QU95S=1w,vwwE=1u,13ZFS=1w,13XNK=1u,15s6Qg=1w,JG36=1u,iv1V6=1w,JG36=1u,gs97a=1w,C42A=1u,vw0NO=1w,EBnq=1u,1gFq0=1w,TPos=1u,1e85a=1w,TPos=1u"
        )

        insert(
            "Brazil/East",
            "3G,-1VB3cg=8,BUMoc=l,13r1u=8,1556w=l,13eQE=8,zB4oE=l,NiOA=8,1l18A=l,HQJi=8,1qtdS=l,IdcQ=8,1qtdS=l,wBXi=8,mJvUc=l,L71e=8,1XP4k=l,lnbi=8,1qPHq=l,wBXi=8,1qPHq=l,HufK=8,1qPHq=l,HQJi=8,BK7iU=l,McrS=8,1jdGU=l,EArm=8,1tJvO=l,C36w=8,1tn2g=l,C36w=8,1vUn6=l,H7Mc=8,1tn2g=l,H7Mc=8,1qPHq=l,EArm=8,1vUn6=l,zvLG=8,1vUn6=l,JF72=8,1oimA=l,JF72=8,1oimA=l,H7Mc=8,1oimA=l,McrS=8,1m7vi=l,QUE0=8,1jdGU=l,McrS=8,1jdGU=l,Rh7y=8,1jdGU=l,McrS=8,1oimA=l,JF72=8,1vUn6=l,C36w=8,1qPHq=l,H7Mc=8,1wDkc=l,DRug=8,1oimA=l,JF72=8,1vUn6=l,EArm=8,1lL1K=l,JF72=8,1qPHq=l,H7Mc=8,1qPHq=l,JF72=8,1oimA=l,JF72=8,1oimA=l,McrS=8,1oimA=l,H7Mc=8,1qPHq=l,H7Mc=8,1qPHq=l,JF72=8,1oimA=l,JF72=8,1oimA=l,JF72=8,1oimA=l,JF72=8,1vUn6=l,C36w=8,1vUn6=l,C36w=8,1vUn6=l,EArm=8,1vUn6=l,C36w=8,1vUn6=l,EArm=8,1tn2g=l,C36w=8,1vUn6=l,C36w=8,1vUn6=l,EArm=8,1tn2g=l,EArm=8,1vUn6=l,C36w=8,1vUn6=l,C36w=8,1vUn6=l,C36w=8,1vUn6=l,C36w=8,1vUn6=l,C36w=8,1yrHW=l,C36w=8,1vUn6=l,EArm=8,1tn2g=l,C36w=8,1vUn6=l,C36w=8,1vUn6=l,EArm=8,1tn2g=l,EArm=8,1vUn6=l"
        )

        link("Etc/GMT", "Etc/GMT+9")

        insert(
            "Asia/Chita",
            "5A,-1IT55K=A,mssa4=G,1KrKjS=L,14khi=G,13ZFS=L,14khi=G,13ZFS=L,14khi=G,14m9q=L,140BW=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,16w4E=G,13YJO=G,13ZFS=A,EBnq=G,pmqk=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,16w4E=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1gFq0=G,Ri3C=L,1gFq0=G,Ri3C=L,1gFq0=G,TPos=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1gFq0=G,Ri3C=L,1gFq0=G,Ri3C=L,1gFq0=G,Ri3C=L,1gFq0=G,TPos=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1gFq0=G,Ri3C=L,7EwUM=A,31OKc=G"
        )

        insert(
            "Pacific/Easter",
            "3H,-2KQwyY=3I,1t7eEw=1i,1ffDAc=R,Rh7y=1i,1oimA=R,JF72=1i,194ly=R,TOso=1i,1e91e=R,TOso=1i,1gGm4=R,Rh7y=1i,1bBGo=R,WlNe=1i,1gGm4=R,Rh7y=1i,1gGm4=R,TOso=1i,1e91e=R,TOso=1i,1e91e=R,TOso=1i,1gGm4=R,Rh7y=1i,1gGm4=R,Rh7y=1i,1gGm4=R,TOso=1i,1e91e=R,TOso=R,1e91e=I,TOso=R,1e91e=I,TOso=R,1gGm4=I,Rh7y=R,1gGm4=I,Rh7y=R,1gGm4=I,13XNK=R,13ZFS=I,TOso=R,1e91e=I,TOso=R,1gGm4=I,Rh7y=R,16x0I=I,11qsU=R,1gGm4=I,TOso=R,1e91e=I,TOso=R,1e91e=I,TOso=R,1e91e=I,TOso=R,1gGm4=I,Rh7y=R,1gGm4=I,YT84=R,194ly=I,TOso=R,194ly=I,16v8A=R,16x0I=I,TOso=R,1gGm4=I,Rh7y=R,1gGm4=I,Rh7y=R,1gGm4=I,Rh7y=R,1gGm4=I,TOso=R,1e91e=I,TOso=R,1e91e=I,TOso=R,1gGm4=I,Rh7y=R,1gGm4=I,YT84=R,194ly=I,TOso=R,1e91e=I,11qsU=R,16x0I=I,1e796=R,C4YE=I,1tla8=R,JGZa=I,1ogus=R,Mek0=I,1lJ9C=R,Mek0=I,3BiDK=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,zxDO=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,zxDO=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,zxDO=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,x0iY=I,1AXaE=R,zxDO=I"
        )

        insert(
            "Antarctica/Davis",
            "1s,-rGV7a=v,gEJeU=1s,956H6=v,1oWjGE=o,Qdz2=v,3u36M=o,GqHe=v"
        )

        insert(
            "Antarctica/McMurdo",
            "2p,-3u38jS=16,221bpK=2q,H7Mc=16,1jdGU=u,TOVq=16,1e8yc=u,TOVq=16,1e8yc=u,TOVq=16,1e8yc=u,Wmgg=16,1bBdm=u,Wmgg=16,1bBdm=u,1bAhi=16,TPRu=u,1e7C8=16,TPRu=u,1e7C8=16,TPRu=u,1e7C8=16,TPRu=u,1e7C8=16,TPRu=u,1gEWY=16,RiwE=u,1gEWY=16,TPRu=u,be0HK=u,ZAvLi=z,EBnq=u,1qOLm=z,MdnW=u,1ohqw=z,JG36=u,1ohqw=z,JG36=u,1ohqw=z,JG36=u,1ohqw=z,JG36=u,1ohqw=z,JG36=u,1ohqw=z,MdnW=u,1ohqw=z,JG36=u,1ohqw=z,JG36=u,1ohqw=z,JG36=u,1ohqw=z,JG36=u,1ohqw=z,JG36=u,1ohqw=z,MdnW=u,1ohqw=z,JG36=u,1gFq0=z,WmJi=u,1bAKk=z,WmJi=u,1bAKk=z,WmJi=u,1bAKk=z,YU48=u,193pu=z,YU48=u,193pu=z,YU48=u,193pu=z,YU48=u,1bAKk=z,WmJi=u,1bAKk=z,WmJi=u,1bAKk=z,YU48=u,193pu=z,YU48=u,193pu=z,YU48=u,1bAKk=z,WmJi=u,1bAKk=z,WmJi=u,1bAKk=z,YU48=u,193pu=z,YU48=u,193pu=z,YU48=u,193pu=z,YU48=u,193pu=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,13YJO=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,13YJO=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,193pu=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,13YJO=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,13YJO=z,16w4E=u,11roY=z,16w4E=u,11roY=z,16w4E=u,11roY=z"
        )

        insert(
            "Asia/Macao",
            "3J,-1ZSdAg=U,1H6rwE=W,1lJ9C=U,Mek0=W,1lJ9C=U,Mb2M=W,1lMqQ=U,OLEQ=W,1jbOM=U,OInC=W,1jbOM=U,YYhq=W,13XNK=U,13ZFS=W,16v8A=U,13ZFS=W,13XNK=U,13ZFS=W,13XNK=U,13ZFS=W,13XNK=U,13ZFS=W,13XNK=U,13WoE=W,13XNK=U,13ZFS=W,16v8A=U,13ZFS=W,1414Y=U,13ZFS=W,13XNK=U,13ZFS=W,13XNK=U,13ZFS=W,13XNK=U,13WoE=W,13XNK=U,13ZFS=W,16v8A=U,13ZFS=W,13XNK=U"
        )

        insert(
            "America/Manaus",
            "3K,-1VB2mo=e,BUMuo=8,13r1u=e,1556w=8,13eQE=e,zB4oE=8,NiOA=e,1l18A=8,HQJi=e,1qtdS=8,IdcQ=e,1qtdS=8,wBXi=e,n0yiY=8,u4Cs=e,1XP4k=8,lnbi=e,1qPHq=8,wBXi=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,BK7iU=8,McrS=e,1jdGU=8,EArm=e,1tJvO=8,C36w=e,c9HLa=8,JF72=e"
        )

        link("Africa/Freetown", "Atlantic/St_Helena")

        insert(
            "Europe/Bucharest",
            "5B,-2H7mXu=2Z,1n17zy=5,1LtGw=6,MzRu=5,13YJO=6,13YJO=5,16w4E=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,1mGspi=6,JF72=5,16w4E=6,11sl2=5,140BW=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13WRG=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13XNK=5,13ZFS=6,13XNK=5,16x0I=6,1e796=5,TT8I=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        insert(
            "Asia/Tomsk",
            "5C,-1IQvYz=r,mpUV1=v,1KrKjS=A,14khi=v,13ZFS=A,14khi=v,13ZFS=A,14khi=v,14m9q=A,140BW=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,16w4E=v,13YJO=v,13ZFS=r,EBnq=v,pmqk=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,16w4E=A,1e85a=v,TPos=A,1e85a=v,TPos=A,1e85a=v,TPos=A,1gFq0=v,Ri3C=A,1gFq0=v,Ri3C=A,1gFq0=v,TPos=A,beM0=v,12Ufe=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,7EwUM=r,3oDPG=v"
        )

        insert(
            "America/Argentina/Mendoza",
            "3L,-2Ax4oA=1v,Sscag=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=e,1jB6w=8,NEm4=e,1kFB6=8,O0PC=e,1lL1K=l,OIQE=8,e2rdK=8,T6rm=8,910TC=e,JGZa=8,6Xocw=l,rTLa=8"
        )

        link("Asia/Macau", "Asia/Macao")

        insert(
            "Europe/Malta",
            "5D,-2CEKBe=0,MetkM=1,H7Mc=0,13ZFS=1,14khi=0,W1bO=1,1etCE=0,QWw8=1,1gEtW=0,YV0c=1,13XNK=0,G9sEo=1,55qve=0,Ri3C=1,16w4E=0,13Cgg=1,YU48=0,19pT2=1,Y9eU=0,14n5u=1,1bAKk=0,WkRa=1,1bAKk=0,RjVK=1,1gFq0=0,BEDlu=1,JF72=0,1qPHq=1,H8Ig=0,1qOLm=1,H8Ig=0,1tm6c=1,H8Ig=0,1qOLm=1,H8Ig=0,1ohqw=1,JG36=0,1qOLm=1,JG36=0,13Cgg=1,13YJO=0,1bXdS=1,RExa=0,1gkOA=1,TOso=0,1e91e=1,TOso=0,1e91e=1,TOso=0,1e91e=1,TOso=0,1e91e=1,TOso=0,19qP6=1,113Zm=0,16x0I=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        link("HST", "Etc/GMT+9")

        insert(
            "Mexico/BajaSur",
            "3M,-1EvGXS=9,bCk2A=3,7kfa8=9,YU48=3,T6rm=9,14m9q=3,lugwg=9,emJUs=a,ILSa4=9,U5IPK=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,16x0I=b,Rh7y=9,16x0I=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9"
        )

        insert(
            "Pacific/Tahiti",
            "5E,-1YgCzm=1y"
        )

        link("Africa/Asmera", "Africa/Nairobi")

        insert(
            "Europe/Busingen",
            "30,-40IL6M=31,1pivvE=0,1CdkGC=1,TPos=0,1e85a=1,TPos=0,1kbjmE=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "America/Argentina/Rio_Gallegos",
            "5F,-2Ax4n2=1v,Ssc8I=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=8,1lL1K=l,McrS=8,1lL1K=l,McrS=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,94hby=e,6TZu=8,7wUUg=l,rTLa=8"
        )

        insert(
            "Africa/Malabo",
            "1U,-1Jv2gg=1b"
        )

        insert(
            "Europe/Skopje",
            "28,-2XFjlK=0,1YmyWk=1,3hMEo=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,1h1Ty=1,LuqQ=0,1i8M6c=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        link("America/Catamarca", "America/Argentina/Catamarca")

        insert(
            "America/Godthab",
            "5G,-1Q6Dmw=8,2c1sic=l,11nEI=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,16w4E=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,16w4E=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,16w4E=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1gFq0=8,Ri3C=l,1gFq0=8,Ri3C=l,1gFq0=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1gFq0=8,Ri3C=l,1gFq0=8,Ri3C=l,1gFq0=8,Ri3C=l,1gFq0=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1gFq0=8,Ri3C=l,1gFq0=8,Ri3C=l,1gFq0=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1gFq0=8,Ri3C=l,1gFq0=8,Ri3C=l,1gFq0=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1gFq0=8,Ri3C=l,1gFq0=8,Ri3C=l,1gFq0=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1gFq0=8,Ri3C=l,1gFq0=8,Ri3C=l,1gFq0=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1gFq0=8,Ri3C=l,1gFq0=8,Ri3C=l,1gFq0=8,Ri3C=l,1gFq0=8,TPos=l,1e85a=8,TPos=l,1e85a=8,TPos=l,1gFq0=8"
        )

        link("Europe/Sarajevo", "Europe/Skopje")

        insert(
            "Australia/ACT",
            "2r,-2zZzOk=i,KNEGY=j,u6tC=i,QU95S=j,vwwE=i,13ZFS=j,13XNK=i,16x0I=j,11qsU=i,WWgVO=j,H8Ig=i,1qOLm=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,MdnW=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,WmJi=i,1e85a=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,OKIM=i,1gFq0=j,Ri3C=i,1jcKQ=j,Ri3C=i,1jcKQ=j,OKIM=i,1jcKQ=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,MdnW=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,TPos=i,1e85a=j,TPos=i,1e85a=j,TPos=i,1e85a=j,TPos=i,1gFq0=j,Ri3C=i,TPos=j,1e85a=i,1gFq0=j,TPos=i,1e85a=j,TPos=i,1e85a=j,TPos=i,1gFq0=j,Ri3C=i,1gFq0=j,TPos=i,1e85a=j,Ri3C=i,1gFq0=j,WmJi=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,16w4E=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j"
        )

        link("GB-Eire", "Europe/London")

        link("Africa/Lagos", "Africa/Malabo")

        link("America/Cordoba", "America/Argentina/Cordoba")

        insert(
            "Europe/Rome",
            "32,-3yyQ72=33,VTJ0o=0,MePQc=1,H7Mc=0,13ZFS=1,14khi=0,W1bO=1,1etCE=0,QWw8=1,1gEtW=0,YV0c=1,13XNK=0,G9sEo=1,55qve=0,Ri3C=1,16w4E=0,13YJO=1,YxAA=0,19pT2=1,Y9eU=0,14n5u=1,1bAKk=0,WkRa=1,1bAKk=0,RjVK=1,1gFq0=0,BEDlu=1,JF72=0,1qPHq=1,H8Ig=0,1qOLm=1,H8Ig=0,1tm6c=1,H8Ig=0,1qOLm=1,H8Ig=0,1ohqw=1,JG36=0,1qOLm=1,JG36=0,1qOLm=1,H8Ig=0,1ohqw=1,JG36=0,1qOLm=1,H8Ig=0,1qOLm=1,H8Ig=0,1ohqw=1,JG36=0,1qOLm=1,JG36=0,1ohqw=1,JG36=0,16xWM=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "Asia/Dacca",
            "3N,-2KQJ2k=2s,1MvJCA=1A,1jV8s=1Q,DwSQ=1A,jo7qo=r,1Zh7pC=v,18GVW=r"
        )

        insert(
            "Indian/Mauritius",
            "5H,-2ay8kw=n,2BPfRu=o,WIgM=n,SG1na=o,TOso=n"
        )

        link("Pacific/Samoa", "Pacific/Pago_Pago")

        insert(
            "America/Regina",
            "3O,-2dowiU=9,qWy0s=b,192tq=9,oB840=b,TOso=9,1e91e=b,TOso=9,1e91e=b,TOso=9,1gGm4=b,Rh7y=9,1gGm4=b,TOso=9,5mrXW=b,13XNK=9,13ZFS=b,11qsU=9,16x0I=b,13XNK=9,16x0I=b,13XNK=9,13ZFS=b,13XNK=9,Hy00=1t,7uY5W=1B,gOlO=9,194ly=b,13XNK=9,194ly=b,TOso=9,1e91e=b,TOso=9,1e91e=b,TOso=9,1gGm4=b,Rh7y=9,1gGm4=b,TOso=9,1e91e=b,TOso=9,1e91e=b,TOso=9,1e91e=b,TOso=9,1e91e=b,TOso=9,1gGm4=b,TOso=9,1e91e=b,TOso=9,3m6uQ=b,13XNK=9,13ZFS=3"
        )

        insert(
            "America/Fort_Wayne",
            "2t,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,KfAJO=7,zvLG=3,MANy=1j,7uZ20=1m,gNpK=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,Rh7y=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=2,5cgKs=3,1e91e=2,nuBZm=4,13XNK=2,13ZFS=4,13XNK=2,1dGboQ=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "America/Dawson_Creek",
            "5I,-2XFayY=a,1bddcA=c,192tq=a,NJEME=1E,7uX9S=1F,gPhS=a,3m6uQ=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1gGm4=c,Rh7y=a,1gGm4=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1gGm4=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1gGm4=c,Rh7y=a,1gGm4=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,13ZFS=c,IdcQ=9"
        )

        insert(
            "Africa/Algiers",
            "5J,-2IhQOY=2m,GGr71=g,bf7Gx=h,DvWM=g,114Vq=h,19pT2=g,TsUU=h,1euyI=g,QVA4=h,1h1Ty=g,LQUo=h,1tm6c=g,PtFS=h,zTbi=g,CUYa4=h,oFlm=g,zyzS=0,8LpsY=1,168F2=0,11OOA=1,YvIs=0,2fVXG=g,jSXO8=0,fo9ri=g,h9EiY=h,TPos=g,bYsZa=h,YT84=0,TQkw=1,13ZFS=0,2kChG=g,13ZFS=h,16x0I=g,13XNK=0"
        )

        insert(
            "Europe/Mariehamn",
            "3P,-39Belf=3Q,1tEAuY=5,IGpLf=6,14HGU=5,1kbGMg=6,13YJO=5,13YJO=6,13YJO=5,13ZFS=6,13YJO=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        insert(
            "America/St_Johns",
            "3R,-2XFeMk=19,192Ip2=1c,WIgM=19,1dMxG=1c,192tq=19,17d9C=1c,zSfe=19,1xIKQ=1c,13XNK=19,13ZFS=1c,13XNK=19,16x0I=1c,11qsU=19,16x0I=1c,11qsU=19,16x0I=1c,11qsU=19,16x0I=1c,11qsU=19,16x0I=1c,13XNK=19,13ZFS=1c,13XNK=19,16x0I=1c,11qsU=19,16x0I=1c,11qsU=19,16x0I=1c,11qsU=19,16x0I=1c,11qsU=19,16x0I=1c,13XNK=19,16x0I=1c,11qsU=19,16x0I=1c,11qsU=19,T8ju=D,doGo=F,11qsU=D,195hC=F,Rh7y=D,1gGm4=F,Rh7y=D,1gGm4=F,Rh7y=D,1jdGU=F,OJMI=D,1jdGU=F,Rh7y=D,1gGm4=F,Rh7y=D,1gGm4=34,6Y3So=35,gL4A=D,1jdGU=F,Rh7y=D,1gGm4=F,Rh7y=D,1gGm4=F,Rh7y=D,1gGm4=F,Rh7y=D,1jdGU=F,Rh7y=D,1bBGo=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1gGm4=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1e91e=F,16v8A=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,16v8A=D,11sl2=F,16v8A=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,16v8A=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,16v8A=D,11sl2=F,16v8A=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,16v8A=D,11sl2=F,16v8A=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,WlOc=F,1bzOg=D,WnFm=3S,1e6d2=D,TRgA=F,1e796=D,TQkw=F,1e796=D,WnFm=F,1bzOg=D,WnFm=F,1bzOg=D,WnFm=F,1e796=D,TQkw=F,1e796=D,TQkw=F,1e796=D,WnFm=F,1bzOg=D,WnFm=F,1bzOg=D,WnFm=F,1bzOg=D,WnFm=F,1e796=D,TQkw=F,1e796=D,TQkw=F,1e796=D,WnFm=F,1bzOg=D,WnFm=F,1bzOg=D,WnFm=F,1e796=D,TQkw=F,1e796=D,TQkw=F,1e796=D,Mek0=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,Mek0=F,1ogus=D,JGZa=F,1oilC=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,Mek0=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,Mek0=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,Mek0=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,Mek0=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,JGZa=F,1ogus=D,Mek0=F,1ogus=D"
        )

        link("America/St_Thomas", "America/Marigot")

        link("Europe/Zurich", "Europe/Busingen")

        link("America/Anguilla", "America/Marigot")

        insert(
            "Asia/Dili",
            "5K,-1ZSekI=A,12noDi=G,1b1A5O=A,Q3zZm=G"
        )

        insert(
            "America/Denver",
            "2u,-2XUXfi=9,1bnUha=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1gEtW=9,RiZG=b,khKE=9,IfBKg=1t,7uY5W=1B,gOlO=9,FMZ6o=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,pois=b,1Izba=9,H9Ek=b,1qNPi=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9"
        )

        link("Africa/Bamako", "Atlantic/St_Helena")

        insert(
            "Europe/Saratov",
            "5L,-1JRvB6=J,nqXlK=n,1KrKjS=o,14khi=n,13ZFS=o,14khi=n,13ZFS=o,14khi=n,14m9q=o,140BW=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=n,13ZFS=J,13YJO=n,13YJO=J,13YJO=n,16w4E=J,13YJO=n,27Wxy=n,13ZFS=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,16w4E=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,7EwUM=J,4v9Uk=n"
        )

        link("GB", "Europe/London")

        insert(
            "Mexico/General",
            "3T,-1EvGXS=9,bCk2A=3,7kfa8=9,YU48=3,T6rm=9,14m9q=3,eCF0s=7,OJMI=3,37eXm=7,EWUU=3,5Myhq=1j,NEm4=3,cm1XO=7,YT84=3,1zzS5G=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,16x0I=7,Rh7y=3,16x0I=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3"
        )

        insert(
            "Pacific/Wallis",
            "5M,-2nmyq4=E"
        )

        insert(
            "Europe/Gibraltar",
            "5N,-34Xm2w=d,1es2UA=f,MdnW=d,16w4E=f,WJcQ=d,169B6=f,16Syc=d,13Cgg=f,14ldm=d,13Cgg=f,1euyI=d,W0fK=f,14ldm=d,114Vq=f,193pu=d,193pu=f,Ri3C=d,1e85a=f,WmJi=d,1e85a=f,YU48=d,193pu=f,YU48=d,16w4E=f,11roY=d,1bAKk=f,YU48=d,193pu=f,YU48=d,16w4E=f,11roY=d,193pu=f,YU48=d,193pu=f,YU48=d,16w4E=f,13YJO=d,193pu=f,YU48=d,16w4E=f,11roY=d,193pu=f,YU48=d,193pu=f,YU48=d,16w4E=f,11roY=d,193pu=f,1gFq0=d,zwHK=f,2xjTW=17,zwHK=f,1ohqw=17,JG36=f,1ohqw=17,MdnW=f,1lK5G=17,YU48=f,19pT2=17,BHz2=f,usY8=d,16w4E=f,11roY=d,WmJi=f,a8pi=17,H8Ig=f,usY8=d,MdnW=f,1lK5G=d,TPos=f,1e85a=d,YU48=f,16w4E=d,11roY=f,16w4E=d,13YJO=f,16w4E=d,11roY=f,YU48=d,16w4E=f,11roY=d,193pu=f,YU48=d,1bAKk=f,YU48=d,16w4E=0,Ri2FW=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        link("Africa/Conakry", "Atlantic/St_Helena")

        link("Africa/Lubumbashi", "Africa/Kigali")

        link("Asia/Istanbul", "Europe/Istanbul")

        link("America/Havana", "Cuba")

        insert(
            "NZ-CHAT",
            "3U,-3u38Ru=3V,2EN3D2=S,ZAvZO=T,EBnq=S,1qOLm=T,MdnW=S,1ohqw=T,JG36=S,1ohqw=T,JG36=S,1ohqw=T,JG36=S,1ohqw=T,JG36=S,1ohqw=T,JG36=S,1ohqw=T,MdnW=S,1ohqw=T,JG36=S,1ohqw=T,JG36=S,1ohqw=T,JG36=S,1ohqw=T,JG36=S,1ohqw=T,JG36=S,1ohqw=T,MdnW=S,1ohqw=T,JG36=S,1gFq0=T,WmJi=S,1bAKk=T,WmJi=S,1bAKk=T,WmJi=S,1bAKk=T,YU48=S,193pu=T,YU48=S,193pu=T,YU48=S,193pu=T,YU48=S,1bAKk=T,WmJi=S,1bAKk=T,WmJi=S,1bAKk=T,YU48=S,193pu=T,YU48=S,193pu=T,YU48=S,1bAKk=T,WmJi=S,1bAKk=T,WmJi=S,1bAKk=T,YU48=S,193pu=T,YU48=S,193pu=T,YU48=S,193pu=T,YU48=S,193pu=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,13YJO=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,13YJO=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,193pu=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,13YJO=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,13YJO=T,16w4E=S,11roY=T,16w4E=S,11roY=T,16w4E=S,11roY=T"
        )

        insert(
            "Asia/Choibalsan",
            "5O,-2dzYLe=v,2uFaNa=A,bcAcE=L,14jle=G,14m9q=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,16v8A=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,16x0I=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,5wgHS=L,TOso=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,13XNK=G,13ZFS=L,16v8A=G,3cEes=A,eVzxe=G,13VVC=A,141y0=G,13VVC=A"
        )

        insert(
            "America/Porto_Acre",
            "36,-1VB1Sg=I,BUMWk=e,13r1u=I,1556w=e,13eQE=I,zB4oE=e,NiOA=I,1l18A=e,HQJi=I,1qtdS=e,IdcQ=I,1qtdS=e,wBXi=I,n0yiY=e,u4Cs=I,1XP4k=e,lnbi=I,1qPHq=e,wBXi=I,1qPHq=e,HufK=I,1qPHq=e,HQJi=I,BK7iU=e,McrS=I,1jdGU=e,EArm=I,1tJvO=e,C36w=I,HwiaI=e,bulyw=I"
        )

        insert(
            "Asia/Omsk",
            "5P,-1J4hmy=o,mDHf4=r,1KrKjS=v,14khi=r,13ZFS=v,14khi=r,13ZFS=v,14khi=r,14m9q=v,140BW=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,16w4E=r,13YJO=r,13ZFS=o,EBnq=r,pmqk=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,16w4E=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,7EwUM=r"
        )

        link("Europe/Vaduz", "Europe/Busingen")

        insert(
            "US/Michigan",
            "3W,-2eODsN=3,m8yFf=2,V6LT2=1R,7uZY4=1S,gMtG=2,5u3Ys=4,TOso=2,QvRa8=4,13XNK=2,pois=4,1Izba=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        link("Asia/Dhaka", "Asia/Dacca")

        insert(
            "America/Barbados",
            "5Q,-1Af5Td=5R,h5iAo=k,1z3ALh=m,EArm=k,194ly=m,YT84=k,194ly=m,YT84=k,1bBGo=m,VgmA=k"
        )

        insert(
            "Europe/Tiraspol",
            "3X,-36cYac=3Y,1jpO04=2Z,sGUMc=5,1LtGw=6,MzRu=5,13YJO=6,13YJO=5,16w4E=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,1RE1W=6,1XNcc=1,2LxaE=0,Ri3C=1,16w4E=0,13YJO=1,PNle=K,1gaAyk=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,fd4Y=6,RjVK=5,13YJO=6,13YJO=5,13WRG=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,16x0I=6,1e796=5,TScE=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        insert(
            "Atlantic/Cape_Verde",
            "5S,-2ay3gU=l,1eaCTW=s,6Fgn6=l,12j6jm=s"
        )

        insert(
            "Asia/Yekaterinburg",
            "5T,-1QfOid=5U,6tnBe=n,nlRvz=o,1KrKjS=r,14khi=o,13ZFS=r,14khi=o,13ZFS=r,14khi=o,14m9q=r,140BW=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,16w4E=o,13YJO=o,13ZFS=n,EBnq=o,pmqk=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,16w4E=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1gFq0=o,Ri3C=r,1gFq0=o,Ri3C=r,1gFq0=o,TPos=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1gFq0=o,Ri3C=r,1gFq0=o,Ri3C=r,1gFq0=o,Ri3C=r,1gFq0=o,TPos=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1gFq0=o,Ri3C=r,7EwUM=o"
        )

        insert(
            "America/Louisville",
            "3Z,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,3euuk=7,IzGo=3,FYdSo=7,TOso=3,MANy=1j,7uZ20=1m,gNpK=3,xHnW=7,T7nq=3,1VhJu=7,7hGTe=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,13ZFS=7,ur60=2,erNE4=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,pois=7,1IA7e=2,H8Ig=4,1qNPi=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        link("Pacific/Johnston", "Pacific/Honolulu")

        link("Pacific/Chatham", "NZ-CHAT")

        link("Europe/Ljubljana", "Europe/Skopje")

        link("America/Sao_Paulo", "Brazil/East")

        insert(
            "Asia/Jayapura",
            "5V,-1hnqs0=G,pgQac=5W,FhMI8=5X"
        )

        insert(
            "America/Curacao",
            "2v,-1ZCOaF=1T,1OWU8B=k"
        )

        insert(
            "Asia/Dushanbe",
            "5Y,-1zwZLq=o,d6pDW=r,1KrKjS=v,14khi=r,13ZFS=v,14khi=r,13ZFS=v,14khi=r,14m9q=v,140BW=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,16w4E=r,13YJO=r,WK8U=o"
        )

        insert(
            "America/Guyana",
            "5Z,-1T7kp2=60,251QIQ=8,wW5Uw=e"
        )

        insert(
            "America/Guayaquil",
            "61,-2KQypi=62,1pysko=I,28dqmA=e,oZWM=I"
        )

        insert(
            "America/Martinique",
            "63,-2KQzzS=64,JxI8o=k,2ndFr6=m,11qsU=k"
        )

        insert(
            "Portugal",
            "37,-1ZS5V1=g,9wTkf=h,NjKE=g,HufK=h,1kEF2=g,O1LG=h,1kibu=g,NFi8=h,1kEF2=g,O1LG=h,1kEF2=g,NFi8=h,1kEF2=g,5lI4M=h,13Cgg=g,3do7C=h,YU48=g,16w4E=h,11roY=g,193pu=h,11roY=g,193pu=h,YU48=g,3h0T6=h,YU48=g,13YJO=h,13YJO=g,3etyg=h,13YJO=g,11roY=h,16w4E=g,193pu=h,YU48=g,13YJO=h,13YJO=g,11roY=h,16w4E=g,193pu=h,1gFq0=g,zwHK=h,1jcKQ=g,13YJO=h,14ldm=g,W0fK=h,fd4Y=1C,EBnq=h,pois=g,OKIM=h,cFK8=1C,MdnW=h,mQXC=g,MdnW=h,fd4Y=1C,JG36=h,mQXC=g,MdnW=h,fd4Y=1C,JG36=h,mQXC=g,WmJi=h,13YJO=g,141y0=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,3bWdq=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=0,mo4YE=g,13YJO=h,13YJO=g,16w4E=h,13YJO=g,13YJO=h,13ZFS=g,13XNK=h,13ZFS=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13ZFS=h,13XNK=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g"
        )

        insert(
            "Europe/Berlin",
            "65,-2DUGZG=0,Ni4Aw=1,TtQY=0,19rLa=1,TPos=0,1e85a=1,TPos=0,K0lMI=1,5wAne=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,iPQs=40,IACs=1,jX9e=0,Ri3C=1,11NSw=0,13Dck=1,cFK8=40,hKpO=1,zxDO=0,193pu=1,YU48=0,16w4E=1,11roY=0,139Z5e=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "Europe/Moscow",
            "41,-36cYI1=42,1fXbR6=2w,27Wwy=2x,12Tja=2w,UaVW=2y,CNVK=2x,1vw1q=2y,aWx1=N,gCaY=K,3d1E4=N,cjgA=o,Xs9W=N,aTew=K,28kTe=5,gukUw=K,1KrKjS=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,16w4E=K,13YJO=6,13ZFS=5,EBnq=K,pmqk=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,16w4E=N,1e85a=K,TPos=N,1e85a=K,TPos=N,1e85a=K,TPos=N,1gFq0=K,Ri3C=N,1gFq0=K,Ri3C=N,1gFq0=K,TPos=N,1e85a=K,TPos=N,1e85a=K,TPos=N,1gFq0=K,Ri3C=N,1gFq0=K,Ri3C=N,1gFq0=K,Ri3C=N,1gFq0=K,TPos=N,1e85a=K,TPos=N,1e85a=K,TPos=N,1gFq0=K,Ri3C=38,7EwUM=K"
        )

        link("Europe/Chisinau", "Europe/Tiraspol")

        insert(
            "America/Puerto_Rico",
            "66,-2r7AuX=k,1u2kkL=26,70XdK=27,gLxC=k"
        )

        insert(
            "America/Rankin_Inlet",
            "1s,-rLgPK=3,hKIxi=43,16w4E=3,uWvYc=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=2,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        insert(
            "Pacific/Ponape",
            "44,-2nmwOU=t"
        )

        insert(
            "Europe/Stockholm",
            "67,-38lhrC=68,IQzBI=0,yXa6q=1,Opbi=0,2bDTJC=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "Europe/Budapest",
            "69,-2JfGtu=0,SD44k=1,TtQY=0,19rLa=1,TPos=0,194ly=1,YT84=0,1evuM=1,1iPle=0,JDQmA=1,3lKXm=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,1eOe4=1,14ldm=0,Sqis=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,11roY=0,19pT2=1,16w4E=0,7E9va=1,McrS=0,1m7vi=1,McrS=0,1qtdS=1,H7Mc=0,1qQDu=1,H9Ek=0,M5KZq=1,11sl2=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "America/Argentina/Jujuy",
            "45,-2Ax4Cc=1v,SscnS=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=e,1ojiE=8,OJMI=e,1bBGo=l,Rgbu=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,gI65i=l,rTLa=8"
        )

        insert(
            "Australia/Eucla",
            "6a,-2ydI0E=1V,J1O3S=1Y,u6tC=1V,QU95S=1Y,vwwE=1V,13ZFS=1Y,13XNK=1V,15s6Qg=1Y,JG36=1V,iv1V6=1Y,JG36=1V,gs97a=1Y,C42A=1V,vw0NO=1Y,EBnq=1V,1gFq0=1Y,TPos=1V,1e85a=1Y,TPos=1V"
        )

        link("Asia/Shanghai", "Asia/Chungking")

        link("Universal", "Etc/GMT+9")

        link("Europe/Zagreb", "Europe/Skopje")

        link("America/Port_of_Spain", "America/Marigot")

        link("Europe/Helsinki", "Europe/Mariehamn")

        insert(
            "Asia/Beirut",
            "6b,-36cYA0=5,1nVGgo=6,1etCE=5,W1bO=6,14khi=5,115Ru=6,192tq=5,194ly=6,Rh7y=5,19ObTO=6,TrYQ=5,1eRYk=6,TrYQ=5,1eRYk=6,TrYQ=5,1ferS=6,TrYQ=5,1eRYk=6,TrYQ=5,mU1J6=6,ABck=5,1eRYk=6,TrYQ=5,1eRYk=6,TrYQ=5,1eRYk=6,TrYQ=5,1ferS=6,TrYQ=5,1eRYk=6,TrYQ=5,1evuM=6,TrYQ=5,bVzaM=6,YT84=5,19qP6=6,YT84=5,19qP6=6,YT84=5,19qP6=6,YT84=5,1l24E=6,NEm4=5,1cH72=6,VCQ8=5,19qP6=6,YT84=5,19qP6=6,YT84=5,19NiE=6,Uxpu=5,11sl2=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,16x0I=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5"
        )

        link("Asia/Tel_Aviv", "Israel")

        insert(
            "Pacific/Bougainville",
            "6c,-36d64M=3C,w2hKg=L,1DqJaM=G,6HPA4=L,2o79mg=t"
        )

        link("US/Central", "America/Chicago")

        insert(
            "Africa/Sao_Tome",
            "6d,-2XFius=37,XNczr=d,3EnUnp=1b"
        )

        insert(
            "Indian/Chagos",
            "6e,-2ay9gg=o,344Cfq=r"
        )

        insert(
            "America/Cayenne",
            "6f,-20WKUU=e,1W8sqQ=8"
        )

        insert(
            "Asia/Yakutsk",
            "6g,-1IT66K=A,mstb4=G,1KrKjS=L,14khi=G,13ZFS=L,14khi=G,13ZFS=L,14khi=G,14m9q=L,140BW=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,16w4E=G,13YJO=G,13ZFS=A,EBnq=G,pmqk=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,16w4E=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1gFq0=G,Ri3C=L,1gFq0=G,Ri3C=L,1gFq0=G,TPos=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1gFq0=G,Ri3C=L,1gFq0=G,Ri3C=L,1gFq0=G,Ri3C=L,1gFq0=G,TPos=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1gFq0=G,Ri3C=L,7EwUM=G"
        )

        insert(
            "Pacific/Galapagos",
            "6h,-1li5nW=I,1TsLf2=R,eKFmE=I,oZWM=R"
        )

        insert(
            "Australia/North",
            "46,-2zZyxq=2b,93UrS=w,BJJre=x,u6tC=w,QU95S=x,vwwE=w,13ZFS=x,13XNK=w,16x0I=x,11qsU=w"
        )

        insert(
            "Europe/Paris",
            "6i,-2IhQMd=2m,GGr5e=g,bf7Fz=h,DvWM=g,114Vq=h,19pT2=g,TsUU=h,1euyI=g,QVA4=h,1h1Ty=g,LQUo=h,1tm6c=g,PtFS=h,1jzeo=g,SJXO=h,193pu=g,1lK5G=h,MdnW=g,11roY=h,16w4E=g,13YJO=h,13YJO=g,193pu=h,YU48=g,16w4E=h,11roY=g,193pu=h,11roY=g,193pu=h,YU48=g,16w4E=h,11roY=g,193pu=h,YU48=g,13YJO=h,13YJO=g,11roY=h,193pu=g,13YJO=h,13YJO=g,11roY=h,16w4E=g,193pu=h,YU48=g,13YJO=h,13YJO=g,11roY=h,16w4E=g,193pu=h,1gFq0=g,zzvW=h,Eb9C=1,55rri=0,Ri3C=1,16w4E=0,13YJO=1,Q9OM=1C,fXUc=h,11PKE=1C,YxAA=0,13cvu0=1,13XNK=0,16xWM=1,11roY=0,16w4E=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "Africa/Ndjamena",
            "6j,-1ZS7qQ=1b,2kLpla=1o,QUE0=1b"
        )

        insert(
            "Pacific/Fiji",
            "6k,-1RIViM=E,2RiwSc=V,H8Ig=E,1tm6c=V,EBnq=E,kPG4U=V,H8Ig=E,1e85a=V,MdnW=E,1lK5G=V,wZmU=E,1AY6I=V,wZmU=E,1Dvry=V,ur60=E,1G3Is=V,rUHe=E,1G2Mo=V,rUHe=E,1IA7e=V,pnmo=E,1IA7e=V,pnmo=E,1IA7e=V,rUHe=E,1G2Mo=V,rUHe=E,1G2Mo=V,rUHe=E,1IA7e=V,pnmo=E,1IA7e=V,pnmo=E,1IA7e=V,pnmo=E,1IA7e=V,rUHe=E,1G2Mo=V,rUHe=E,1G2Mo=V,rUHe=E,1IA7e=V,pnmo=E,1IA7e=V,pnmo=E,1IA7e=V,rUHe=E,1G2Mo=V,rUHe=E,1G2Mo=V,rUHe=E,1IA7e=V,pnmo=E,1IA7e=V,pnmo=E,1IA7e=V,pnmo=E,1IA7e=V,rUHe=E,1G2Mo=V,rUHe=E,1G2Mo=V,rUHe=E,1IA7e=V"
        )

        insert(
            "America/Rainy_River",
            "6l,-2AazeU=3,NIA0o=7,192tq=3,KP5zq=7,2Uzde=1j,7uZ20=1m,gNpK=3,Z1H4A=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        insert(
            "Indian/Maldives",
            "6m,-36d0X6=6n,2KQDok=o"
        )

        insert(
            "Australia/Yancowinna",
            "47,-2zZzcw=i,3kgDW=2b,5JEt2=w,BJJre=x,u6tC=w,QU95S=x,vwwE=w,13ZFS=x,13XNK=w,16x0I=x,11qsU=w,WWgVO=x,H8Ig=w,1qOLm=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,MdnW=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,WmJi=w,1e85a=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,OKIM=w,1gFq0=x,Ri3C=w,1jcKQ=x,Ri3C=w,1jcKQ=x,OKIM=w,1jcKQ=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,MdnW=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,TPos=w,1e85a=x,TPos=w,1e85a=x,TPos=w,1e85a=x,TPos=w,1gFq0=x,Ri3C=w,1gFq0=x,Ri3C=w,1gFq0=x,TPos=w,1e85a=x,TPos=w,1e85a=x,TPos=w,1gFq0=x,Ri3C=w,1gFq0=x,TPos=w,1e85a=x,Ri3C=w,1gFq0=x,WmJi=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,16w4E=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,16w4E=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,16w4E=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,16w4E=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,16w4E=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x"
        )

        insert(
            "Asia/Oral",
            "6o,-1zwYFS=J,d6qqw=o,1KrJnO=r,14khi=r,13YJO=r,14ldm=o,13ZFS=r,14khi=o,14m9q=r,140BW=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=o,13ZFS=n,13YJO=o,16w4E=n,13YJO=o,13YJO=n,EBnq=o,pmqk=o,13ZFS=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,16w4E=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=o"
        )

        insert(
            "America/Yellowknife",
            "1s,-1cKwGA=9,fbfEc=1t,7uY5W=1B,gOlO=9,FMXeg=48,16w4E=9,uWvYc=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9"
        )

        insert(
            "Pacific/Enderbury",
            "6p,-2nmcgc=2F,2IaY9e=2e,wzC80=V"
        )

        insert(
            "America/Juneau",
            "6q,-3wgI1x=6r,1884QI=a,1qzn4v=1E,7uX9S=1F,gPhS=a,OlmlG=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,pois=c,1Izba=a,H9Ek=c,1qNPi=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=1p,13YJO=a,13YJO=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=1a,beM0=p,SLPW=q,13XNK=p,13ZFS=q,13XNK=p,13ZFS=q,13XNK=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p"
        )

        insert(
            "Australia/Victoria",
            "49,-2zZzq8=i,KNEiM=j,u6tC=i,QU95S=j,vwwE=i,13ZFS=j,13XNK=i,16x0I=j,11qsU=i,WWgVO=j,H8Ig=i,1qOLm=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,MdnW=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,MdnW=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,OKIM=i,1gFq0=j,Ri3C=i,1gFq0=j,TPos=i,1jcKQ=j,OKIM=i,1jcKQ=j,OKIM=i,1jcKQ=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,MdnW=i,1ohqw=j,JG36=i,1ohqw=j,Ri3C=i,1gFq0=j,TPos=i,1e85a=j,TPos=i,1e85a=j,TPos=i,1e85a=j,TPos=i,1gFq0=j,Ri3C=i,TPos=j,1e85a=i,1gFq0=j,TPos=i,1e85a=j,TPos=i,1e85a=j,TPos=i,1gFq0=j,Ri3C=i,1gFq0=j,TPos=i,1e85a=j,Ri3C=i,1gFq0=j,WmJi=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,16w4E=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j"
        )

        insert(
            "America/Indiana/Vevay",
            "6s,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,iimaY=2,w2ZeE=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,19nJ6M=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "Asia/Tashkent",
            "6t,-1zwZNl=o,d6pFR=r,1KrKjS=v,14khi=r,13ZFS=v,14khi=r,13ZFS=v,14khi=r,14m9q=v,140BW=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,16w4E=r,13YJO=r,13ZFS=o"
        )

        insert(
            "Asia/Jakarta",
            "6u,-3wGcxy=6v,1WqW3K=29,iRRWE=1G,k363K=G,7u0CQ=1G,5yMDC=A,4gDri=1G,tc648=3i"
        )

        insert(
            "Africa/Ceuta",
            "6w,-2nmmWs=g,B2AeY=h,TOso=g,bNAGI=h,100qQ=g,3gZX2=h,YV0c=g,16v8A=h,11sl2=g,193pu=h,11roY=g,1kyjGU=h,Hj0Y=g,en6o0=h,oZWM=g,3yqHu=h,xkUo=g,1AZ2M=h,Smyc=g,1rcaY=h,nbz2=g,bZypO=0,4lJw4=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "Asia/Barnaul",
            "6x,-1IURCs=r,mugyU=v,1KrKjS=A,14khi=v,13ZFS=A,14khi=v,13ZFS=A,14khi=v,14m9q=A,140BW=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,16w4E=v,13YJO=v,13ZFS=r,EBnq=v,pmqk=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,mNdm=v,Hcsw=r,16w4E=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,Ri3C=v,1gFq0=r,TPos=v,1e85a=r,TPos=v,1e85a=r,TPos=v,1gFq0=r,Ri3C=v,7EwUM=r,31NO8=v"
        )

        insert(
            "America/Recife",
            "6y,-1VB3VC=8,BUN7y=l,13r1u=8,1556w=l,13eQE=8,zB4oE=l,NiOA=8,1l18A=l,HQJi=8,1qtdS=l,IdcQ=8,1qtdS=l,wBXi=8,n0yiY=l,u4Cs=8,1XP4k=l,lnbi=8,1qPHq=l,wBXi=8,1qPHq=l,HufK=8,1qPHq=l,HQJi=8,BK7iU=l,McrS=8,1jdGU=l,EArm=8,1tJvO=l,C36w=8,1tn2g=l,C36w=8,1vUn6=l,H7Mc=8,kAsZW=l,Rh7y=8,1jdGU=l,2woM=8,27YpG=l,JF72=8"
        )

        insert(
            "America/Buenos_Aires",
            "4a,-2Ax52I=1v,SscOo=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=8,1lL1K=l,McrS=8,1lL1K=l,McrS=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,gI65i=l,rTLa=8,1gGm4=l,Rh7y=8"
        )

        insert(
            "America/Noronha",
            "4b,-1VB45e=l,BUMl6=s,13r1u=l,1556w=s,13eQE=l,zB4oE=s,NiOA=l,1l18A=s,HQJi=l,1qtdS=s,IdcQ=l,1qtdS=s,wBXi=l,n0yiY=s,u4Cs=l,1XP4k=s,lnbi=l,1qPHq=s,wBXi=l,1qPHq=s,HufK=l,1qPHq=s,HQJi=l,BK7iU=s,McrS=l,1jdGU=s,EArm=l,1tJvO=s,C36w=l,1tn2g=s,C36w=l,1vUn6=s,H7Mc=l,kAsZW=s,Rh7y=l,1jdGU=s,2woM=l,27YpG=s,JF72=l"
        )

        insert(
            "America/Swift_Current",
            "6z,-2dow6A=9,qWxO8=b,192tq=9,NJEME=1t,7uY5W=1B,gOlO=9,1e91e=b,YT84=9,194ly=b,TOso=9,1e91e=b,TOso=9,1e91e=b,TOso=9,gcW2c=b,13XNK=9,3bX9u=b,13XNK=9,13ZFS=b,TOso=9,1gGm4=b,Rh7y=9,mDlNS=3"
        )

        insert(
            "Australia/Adelaide",
            "4c,-2zZz1q=2b,93UVS=w,BJJre=x,u6tC=w,QU95S=x,vwwE=w,13ZFS=x,13XNK=w,16x0I=x,11qsU=w,WWgVO=x,H8Ig=w,1qOLm=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,MdnW=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,MdnW=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,JG36=w,1ohqw=x,OKIM=w,1gFq0=x,Ri3C=w,1jcKQ=x,Ri3C=w,1jcKQ=x,OKIM=w,1jcKQ=x,OKIM=w,1jcKQ=x,JG36=w,1ohqw=x,Ri3C=w,1gFq0=x,MdnW=w,1ohqw=x,OKIM=w,1jcKQ=x,Ri3C=w,1gFq0=x,TPos=w,1e85a=x,TPos=w,1e85a=x,TPos=w,1e85a=x,TPos=w,1gFq0=x,Ri3C=w,1gFq0=x,Ri3C=w,1gFq0=x,TPos=w,1e85a=x,TPos=w,1e85a=x,TPos=w,1gFq0=x,Ri3C=w,1gFq0=x,TPos=w,1e85a=x,Ri3C=w,1gFq0=x,WmJi=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,16w4E=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,16w4E=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,16w4E=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,16w4E=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,16w4E=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x,13YJO=w,13YJO=x"
        )

        insert(
            "America/Metlakatla",
            "6A,-3wgI1x=6B,1884FH=a,1qznfw=1E,7uX9S=1F,gPhS=a,OlmlG=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,pois=c,1Izba=a,H9Ek=c,1qNPi=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,16lWeI=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p"
        )

        link("Africa/Djibouti", "Africa/Nairobi")

        insert(
            "America/Paramaribo",
            "6C,-220n0c=6D,PfTLm=6E,mXh4I=1I,1liaOw=8"
        )

        link("EST", "Etc/GMT+9")

        insert(
            "Europe/Simferopol",
            "6F,-36cYuA=6G,1wG0TS=5,d6qhq=K,ogPni=1,28KaY=0,Ri3C=1,16w4E=0,13YJO=1,3zXi=K,1gWNWg=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,1Dvry=5,3IUEg=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,cFK8=N,Rh7y=K,13ZFS=N,13XNK=K,16x0I=N,1eaTm=K,TQkw=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TOso=38,1e6d2=K"
        )

        insert(
            "Europe/Sofia",
            "6H,-36cXOQ=2i,vQFBa=5,1ElksE=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,13ZFS=5,1aBp60=6,14m9q=5,168F2=6,11OOA=5,168F2=6,11th6=5,16ucw=6,11uda=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13WRG=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,16x0I=6,1e796=5,TT8I=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        link("Africa/Nouakchott", "Atlantic/St_Helena")

        insert(
            "Europe/Prague",
            "4d,-48h9e8=4e,1r9MZO=0,QuJPa=1,TtQY=0,19rLa=1,TPos=0,1e85a=1,TPos=0,K0lMI=1,5wAne=0,Ri3C=1,16w4E=0,13YJO=1,YxAA=0,1bAKk=1,1jcKQ=0,ZgxG=1,TsUU=0,193pu=1,YU48=0,193pu=1,YU48=0,169B6=1,11NSw=0,10ZugM=1,13YJO=0,16w4E=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "America/Indiana/Vincennes",
            "6I,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,1e91e=7,TOso=3,e2rdK=7,TOso=3,1e91e=7,TOso=3,1gEtW=7,RiZG=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,16v8A=3,13ZFS=7,Rh7y=3,1gGm4=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=2,aGjMQ=4,13XNK=2,13ZFS=4,13XNK=2,1dGboQ=7,1e85a=3,Mek0=7,1ogus=2,JG36=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "Antarctica/Mawson",
            "1s,-xV0Gc=r,1UUg7K=o"
        )

        link("America/Kralendijk", "America/Curacao")

        insert(
            "Antarctica/Troll",
            "1s,1cZKHC=y,fBqE=1d,1gFq0=y,Ri3C=1d,1gFq0=y,Ri3C=1d,1gFq0=y,TPos=1d,1e85a=y,TPos=1d,1e85a=y,TPos=1d,1gFq0=y,Ri3C=1d,1gFq0=y,Ri3C=1d,1gFq0=y,TPos=1d,1e85a=y,TPos=1d,1e85a=y,TPos=1d,1e85a=y,TPos=1d,1gFq0=y,Ri3C=1d,1gFq0=y,Ri3C=1d,1gFq0=y,TPos=1d,1e85a=y,TPos=1d,1e85a=y,TPos=1d,1gFq0=y,Ri3C=1d,1gFq0=y,Ri3C=1d,1gFq0=y,TPos=1d,1e85a=y,TPos=1d,1e85a=y,TPos=1d,1e85a=y,TPos=1d,1gFq0=y,Ri3C=1d,1gFq0=y,Ri3C=1d,1gFq0=y,TPos=1d,1e85a=y,TPos=1d,1e85a=y,TPos=1d,1gFq0=y,Ri3C=1d,1gFq0=y,Ri3C=1d,1gFq0=y,Ri3C=1d,1gFq0=y,TPos=1d,1e85a=y,TPos=1d,1e85a=y,TPos=1d,1gFq0=y"
        )

        insert(
            "Europe/Samara",
            "6J,-1JRvB6=J,nqXlK=n,1KrKjS=o,14khi=n,13ZFS=o,14khi=n,13ZFS=o,14khi=n,14m9q=o,140BW=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=n,13ZFS=J,13YJO=n,16w4E=J,13YJO=J,13ZFS=J,7C0w=n,WkRa=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,16w4E=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=n,1gGm4=J,Ri3C=n"
        )

        insert(
            "Indian/Christmas",
            "6K,-2zZwYc=v"
        )

        link("America/Antigua", "America/Marigot")

        insert(
            "Pacific/Gambier",
            "6L,-1YgDtW=6M"
        )

        link("America/Indianapolis", "America/Fort_Wayne")

        insert(
            "America/Inuvik",
            "1s,-AiV7W=a,qioHC=6N,16w4E=a,sOyuA=9,27Wxy=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9"
        )

        insert(
            "America/Iqaluit",
            "1s,-WyH16=1R,6uo4E=1S,gMtG=2,FMXeg=6O,16w4E=2,uWvYc=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=3,TRgA=7,1e796=2,TPos=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "Pacific/Funafuti",
            "6P,-2nmy8c=E"
        )

        link("UTC", "Etc/GMT+9")

        insert(
            "Antarctica/Macquarie",
            "1s,-2pQNY4=i,A7yRq=j,11qsU=i,4jaj6=1s,ZTQvS=i,FGk5W=j,13YJO=i,1e85a=j,MdnW=i,1lK5G=j,MdnW=i,1lK5G=j,OKIM=i,1lK5G=j,H8Ig=i,1qOLm=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,MdnW=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,TPos=i,1gFq0=j,Ri3C=i,1gFq0=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1lK5G=j,Ri3C=i,1jcKQ=j,Ri3C=i,1jcKQ=j,OKIM=i,1jcKQ=j,OKIM=i,1jcKQ=j,TPos=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,13YJO=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,TPos=j,1e85a=i,193pu=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,13YJO=i,13YJO=j,11roY=i,193pu=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=t"
        )

        insert(
            "Canada/Pacific",
            "4f,-2XFanO=a,1bdd1q=c,192tq=a,NJEME=1E,7uX9S=1F,gPhS=a,1e91e=c,YT84=a,194ly=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1gGm4=c,Rh7y=a,1gGm4=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1gGm4=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1gGm4=c,Rh7y=a,1gGm4=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a"
        )

        insert(
            "America/Moncton",
            "6Q,-2XNyZe=2,DxpjK=k,xO8yQ=m,192tq=k,vefrW=m,wYqQ=k,1AZ2M=m,wYqQ=k,1AZ2M=m,wYqQ=k,1AZ2M=m,wYqQ=k,1AZ2M=m,wYqQ=k,1AZ2M=m,wYqQ=k,1y5eo=m,H7Mc=k,1oEQ8=m,JiDu=k,1jAas=m,QUE0=k,MYda=26,7v0U8=27,gLxC=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1gGm4=m,Rh7y=k,1gGm4=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1e91e=m,TOso=k,1gGm4=m,TOso=k,1e91e=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,13ZFS=m,13XNK=k,3bX9u=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WlOc=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,Mgba=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k"
        )

        link("Africa/Gaborone", "Africa/Kigali")

        link("Pacific/Chuuk", "Pacific/Yap")

        insert(
            "Asia/Pyongyang",
            "6R,-27STgE=1x,80EOw=1z,19R4j6=1Z,2prqBG=1x"
        )

        link("America/St_Vincent", "America/Marigot")

        insert(
            "Asia/Gaza",
            "6S,-2nTKWk=5,1mIh4k=6,5a5Ta=5,SMM0=6,1fxba=5,T7nq=6,1fz3i=5,Yc36=6,1a9Mc=5,Yc36=6,1a61W=5,mtcsw=6,QbGU=5,1eRYk=6,TrYQ=5,1eSUo=6,T7nq=5,1fz3i=6,T7nq=5,1fczK=6,T7nq=5,1fczK=6,T7nq=5,1fczK=6,T7nq=5,1fz3i=6,T7nq=5,1fczK=6,T7nq=5,1fczK=6,TtQY=5,1eQ6c=6,cEO4=B,f8AOQ=C,zvLG=B,16x0I=C,McrS=B,kxVF6=C,TOso=B,1qPHq=C,EArm=B,1hLMI=C,SJ1K=B,1e91e=C,Rh7y=B,1oimA=C,JF72=B,1bBGo=C,TOso=B,1e91e=C,WlNe=B,1e91e=C,WlNe=B,1dq48=C,Uxpu=B,1dq48=C,S04E=B,1fXoY=C,Uxpu=B,Hw7S=5,yrh6=6,YU48=5,193pu=6,YU48=5,193pu=6,YU48=5,1e85a=6,13XNK=5,16x0I=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,YU48=5,193pu=6,10mUo=5,12Sn6=6,113Zm=5,17fXO=6,XPzy=5,19oWY=6,TOso=5,1e91e=6,WmJi=5,1bXeQ=6,NEl6=5,1mtZO=6,IdbS=5,1pKgM=6,11roY=5,16w4E=6,13XNK=5,13ZFS=6,1e796=5,UcO4=6,1dKFy=5,UdK8=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5"
        )

        link("Etc/Universal", "Etc/GMT+9")

        insert(
            "PST8PDT",
            "a,-1Mx224=c,1e796=a,TQkw=c,1e796=a,LBHj2=1E,7uX9S=1F,gPhS=a,K5ros=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,pois=c,1Izba=a,H9Ek=c,1qNPi=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a"
        )

        insert(
            "Atlantic/Faeroe",
            "4g,-28m7B6=g,2wmiVi=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,16w4E=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g"
        )

        insert(
            "Asia/Qyzylorda",
            "6T,-1zwZyw=n,d6qn6=o,1KrKjS=r,14khi=r,13YJO=r,14ldm=o,13ZFS=r,14khi=o,14m9q=r,140BW=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,16w4E=o,13YJO=o,13ZFS=o,EArm=r,pmqk=r,13ZFS=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,16w4E=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1gFq0=o,Ri3C=r,1gFq0=o,Ri3C=r,1gFq0=o,TPos=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1gFq0=r"
        )

        link("Canada/Newfoundland", "America/St_Johns")

        link("America/Kentucky/Louisville", "America/Louisville")

        insert(
            "America/Yakutat",
            "6U,-3wgI1x=6V,1885bg=1a,1qznG1=2j,7uWdO=2k,gQdW=1a,OlmlG=1p,13XNK=1a,13ZFS=1p,13XNK=1a,13ZFS=1p,16v8A=1a,13ZFS=1p,13XNK=1a,13ZFS=1p,13XNK=1a,pois=1p,1Izba=1a,H9Ek=1p,1qNPi=1a,13ZFS=1p,16v8A=1a,11sl2=1p,16v8A=1a,13ZFS=1p,13XNK=1a,13ZFS=1p,13XNK=1a,13ZFS=1p,13XNK=1a,13ZFS=1p,13XNK=1a,13ZFS=1p,16v8A=1a,11sl2=1p,16v8A=1a,bdPW=p,SLPW=q,13XNK=p,13ZFS=q,13XNK=p,13ZFS=q,13XNK=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p"
        )

        insert(
            "Asia/Ho_Chi_Minh",
            "4h,-2bCT5K=4i,ajRb4=v,15DGjY=A,4HseQ=G,ZZuM=v,3mQo0=A,hCh1e=v,9ClZ6=A,wZmU0=v"
        )

        insert(
            "Antarctica/Casey",
            "1s,-28jXa=A,1p7xwA=t,NYXu=A,3whIk=t,GoP6=A,9XJao=t"
        )

        insert(
            "Europe/Copenhagen",
            "6W,-2KQEb2=6X,8xEic=0,LLs9m=1,Onja=0,Orxo4=1,5gFhe=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,MWl2=0,1vTr2=1,IACs=0,1qOLm=1,zwHK=0,1AY6I=1,wZmU=0,15Cffy=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "ROC",
            "4j,-2y2sM8=U,1r9N5C=1z,h1FOU=U,1nytq=W,Onja=U,194ly=W,1aunC=U,13ZFS=W,TrYQ=U,1eRYk=W,TrYQ=U,1eRYk=W,TrYQ=U,1eRYk=W,TrYQ=U,T7nq=W,1qNPi=U,SKTS=W,1fz3i=U,SKTS=W,1fz3i=U,SKTS=W,14khi=U,14m9q=W,14khi=U,13ZFS=W,14khi=U,13ZFS=W,14khi=U,13ZFS=W,14khi=U,1qtdS=W,IdcQ=U,1q6Kk=W,IdcQ=U,qGWys=W,14khi=U,13ZFS=W,14khi=U,80jnO=W,xkUo=U"
        )

        link("Africa/Asmara", "Africa/Nairobi")

        insert(
            "Atlantic/Azores",
            "6Y,-2XFgt2=6Z,XNbLi=l,9wTZ6=s,NjKE=l,HufK=s,1kEF2=l,O1LG=s,1kibu=l,NFi8=s,1kEF2=l,O1LG=s,1kEF2=l,NFi8=s,1kEF2=l,5lI4M=s,13Cgg=l,3do7C=s,YU48=l,16w4E=s,11roY=l,193pu=s,11roY=l,193pu=s,YU48=l,3h0T6=s,YU48=l,13YJO=s,13YJO=l,3etyg=s,13YJO=l,11roY=s,16w4E=l,193pu=s,YU48=l,13YJO=s,13YJO=l,11roY=s,16w4E=l,193pu=s,1gFq0=l,zwHK=s,1jcKQ=l,13YJO=s,14ldm=l,W0fK=s,fd4Y=y,EBnq=s,pois=l,OKIM=s,cFK8=y,MdnW=s,mQXC=l,MdnW=s,fd4Y=y,JG36=s,mQXC=l,MdnW=s,fd4Y=y,JG36=s,mQXC=l,WmJi=s,13YJO=l,141y0=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,3bWdq=s,16w4E=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,16w4E=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,16w4E=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,13YJO=l,13YJO=s,ns2Mo=y,13YJO=s,16w4E=y,13YJO=s,13YJO=y,13ZFS=s,13XNK=y,13ZFS=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13ZFS=y,13XNK=s,13YJO=y,16w4E=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,16w4E=s,13YJO=y,13YJO=s,13YJO=y,13YJO=g,13XNK=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,16w4E=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s"
        )

        insert(
            "Europe/Vienna",
            "70,-2DUHbb=0,Ni4M1=1,TtQY=0,19rLa=1,TPos=0,1e85a=1,TPos=0,3jydW=1,WmJi=0,FKqPu=1,5wAne=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,3CLu=0,292Ug=1,11roY=0,13YJO=1,13YJO=0,193pu=1,YU48=0,15hUGI=1,11qsU=0,141y0=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "ROK",
            "4k,-27STlm=1x,80ETe=1z,19Wvsk=1Z,idD2M=1x,2oDRS=1J,K1AA=1x,1u5Zm=1J,McrS=1x,1gGm4=1J,OJMI=1x,1jdGU=1J,OJMI=1x,1jdGU=1J,OJMI=1x,1jdGU=1J,OJMI=1x,1UciQ=1Z,SZde8=2z,TPos=1Z,1e85a=2z,TPos=1Z"
        )

        insert(
            "Pacific/Pitcairn",
            "71,-2nmeOU=72,3lPY7q=73"
        )

        link("America/Mazatlan", "Mexico/BajaSur")

        insert(
            "Australia/Queensland",
            "4l,-2AaOHm=i,KYTA0=j,u6tC=i,QU95S=j,vwwE=i,13ZFS=j,13XNK=i,16x0I=j,11qsU=i,WWgVO=j,H8Ig=i,BJJTi=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i"
        )

        insert(
            "Pacific/Nauru",
            "74,-1GzddW=1K,JbXbS=G,5avDW=1K,1c7HlK=E"
        )

        insert(
            "Europe/Tirane",
            "75,-1VB7lu=0,Uv5yM=1,5541G=0,Ri3C=1,4lIA=0,14lxXq=1,SJ1K=0,1evuM=1,TOso=0,1ferS=1,TOso=0,1gGm4=1,Rh7y=0,1gjSw=1,RDB6=0,1gjSw=1,RDB6=0,1gjSw=1,TOso=0,1bY9W=1,TOso=0,1gGm4=1,TOso=0,19qP6=1,YaaY=0,14m9q=1,140BW=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "Asia/Kolkata",
            "4m,-3YH2Iw=2s,x84li=4n,1eSuFk=2c,1eluEK=1A,1jULS=2c,DwSQ=1A,6Fgn6=2c"
        )

        link("Australia/Canberra", "Australia/ACT")

        insert(
            "MET",
            "10,-1QCCpa=12,TtQY=10,19rLa=12,TPos=10,1e85a=12,TPos=10,K0lMI=12,5wAne=10,Ri3C=12,16w4E=10,13YJO=12,13YJO=10,13YJO=12,YxAA=10,15n1ew=12,11roY=10,16w4E=12,13YJO=10,13YJO=12,13YJO=10,16w4E=12,11roY=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,13YJO=12,16w4E=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,13YJO=12,16w4E=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,13YJO=12,13YJO=10,16w4E=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1gFq0=10,Ri3C=12,1gFq0=10,Ri3C=12,1gFq0=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1gFq0=10,Ri3C=12,1gFq0=10,Ri3C=12,1gFq0=10,Ri3C=12,1gFq0=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1gFq0=10,Ri3C=12,1gFq0=10,Ri3C=12,1gFq0=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1gFq0=10,Ri3C=12,1gFq0=10,Ri3C=12,1gFq0=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1gFq0=10,Ri3C=12,1gFq0=10,Ri3C=12,1gFq0=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1gFq0=10,Ri3C=12,1gFq0=10,Ri3C=12,1gFq0=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1gFq0=10,Ri3C=12,1gFq0=10,Ri3C=12,1gFq0=10,Ri3C=12,1gFq0=10,TPos=12,1e85a=10,TPos=12,1e85a=10,TPos=12,1gFq0=10"
        )

        link("Australia/Broken_Hill", "Australia/Yancowinna")

        insert(
            "Europe/Riga",
            "76,-36cXS2=39,1jLdZe=4o,TPos=39,19pT2=4o,iuiY=39,eSXw4=5,up7SW=K,1VCkU=1,2RkNq=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,3XmU=K,1fSrMQ=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=6,13ZFS=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,16w4E=6,13YJO=5,13ZFS=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,2Zfxe=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        link("America/Dominica", "America/Marigot")

        link("Africa/Abidjan", "Atlantic/St_Helena")

        link("America/Mendoza", "America/Argentina/Mendoza")

        insert(
            "America/Santarem",
            "77,-1VB2GY=e,BUMOY=8,13r1u=e,1556w=8,13eQE=e,zB4oE=8,NiOA=e,1l18A=8,HQJi=e,1qtdS=8,IdcQ=e,1qtdS=8,wBXi=e,n0yiY=8,u4Cs=e,1XP4k=8,lnbi=e,1qPHq=8,wBXi=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,BK7iU=8,McrS=e,1jdGU=8,EArm=e,1tJvO=8,C36w=e,HwiaI=8"
        )

        link("Kwajalein", "Pacific/Kwajalein")

        insert(
            "America/Asuncion",
            "78,-2KQzN6=79,1rcGOc=e,1pvVdK=8,3chKU=e,3cG6A=8,T5vi=e,1fAVq=8,SJ1K=e,1fAVq=8,SJ1K=e,1fAVq=8,13XNK=e,14m9q=8,14khi=e,14m9q=8,13XNK=e,14m9q=8,13XNK=e,14m9q=8,13XNK=e,14m9q=8,14khi=e,14m9q=8,13XNK=e,14m9q=8,13XNK=e,14m9q=8,13XNK=e,14m9q=8,14khi=e,14m9q=8,13XNK=e,1bY9W=8,WlNe=e,14m9q=8,13XNK=e,16axa=8,Rh7y=e,1h2PC=8,129q0=e,14ICY=8,S04E=e,1gjSw=8,RDB6=e,1gGm4=8,T5vi=e,1hpja=8,OJMI=e,1jdGU=8,Rh7y=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,13XNK=e,RiZG=8,1gEtW=e,TQkw=8,1e796=e,194ly=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1jdGU=8,OJMI=e,1jdGU=8,OJMI=e,1jdGU=8,11qsU=e,11sl2=8,16v8A=e,11sl2=8,16v8A=e,13ZFS=8,YT84=e,194ly=8,YT84=e,194ly=8,YT84=e,194ly=8,11qsU=e,16x0I=8,11qsU=e,16x0I=8,11qsU=e,194ly=8,YT84=e,194ly=8,YT84=e,194ly=8,11qsU=e,16x0I=8,11qsU=e,16x0I=8,11qsU=e,16x0I=8,11qsU=e,194ly=8,YT84=e,194ly=8,YT84=e,194ly=8,11qsU=e,16x0I=8,11qsU=e,16x0I=8,11qsU=e,194ly=8,YT84=e,194ly=8,YT84=e,194ly=8,11qsU=e,16x0I=8,11qsU=e,16x0I=8,11qsU=e,16x0I=8,11qsU=e,194ly=8,YT84=e,194ly=8,YT84=e,194ly=8,11qsU=e,16x0I=8"
        )

        insert(
            "Asia/Ulan_Bator",
            "4p,-2dzYhK=v,2uFajG=A,bcAcE=G,14khi=A,14m9q=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,16v8A=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,16x0I=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,5wgHS=G,TOso=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,13XNK=A,13ZFS=G,16v8A=A,i8cPC=G,13VVC=A,141y0=G,13VVC=A"
        )

        link("NZ", "Antarctica/McMurdo")

        insert(
            "America/Boise",
            "7a,-2XUWje=a,1bnUha=c,1e796=a,TQkw=c,1e796=a,7zu7e=9,E2cfK=1t,7uY5W=1B,gOlO=9,K5ros=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,zxDO=b,1ypPO=9,H9Ek=b,1qNPi=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9"
        )

        insert(
            "Australia/Currie",
            "7b,-2yKIjC=i,J1tcY=j,11qsU=i,QU95S=j,vwwE=i,13ZFS=j,13XNK=i,16x0I=j,11qsU=i,WWgVO=j,H8Ig=i,1qOLm=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,MdnW=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,TPos=i,1gFq0=j,Ri3C=i,1gFq0=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1lK5G=j,Ri3C=i,1jcKQ=j,Ri3C=i,1jcKQ=j,OKIM=i,1jcKQ=j,OKIM=i,1jcKQ=j,TPos=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,13YJO=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,TPos=j,1e85a=i,193pu=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,11roY=i,16w4E=j,13YJO=i,13YJO=j,11roY=i,193pu=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,16w4E=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,16w4E=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j,13YJO=i,13YJO=j"
        )

        insert(
            "EST5EDT",
            "2,-1Mx4Qg=4,1e796=2,TQkw=4,1e796=2,LBHj2=1R,7uZY4=1S,gMtG=2,K5ros=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,pois=4,1Izba=2,H9Ek=4,1qNPi=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "Pacific/Guam",
            "4q,-4iXfBW=4r,1VAJDa=4s,3rvYIA=4t"
        )

        insert(
            "Pacific/Wake",
            "7c,-2nmxlq=E"
        )

        insert(
            "Atlantic/Bermuda",
            "7d,-1nqp0S=k,1wEyGC=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k"
        )

        insert(
            "America/Costa_Rica",
            "7e,-2KQy8X=7f,14hAAw=3,206BVx=7,zvLG=3,1yrHW=7,zvLG=3,mI400=7,X4Kk=3,1aSJi=7,kEec=3"
        )

        insert(
            "America/Dawson",
            "7g,-2o8O6g=1a,BGRFW=1p,192tq=1a,1e91e=1p,VXry=1a,LzyjS=2j,7uWdO=2k,gQdW=1a,FMXeg=2P,16w4E=1a,h4d9K=a,dShSo=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a"
        )

        link("Asia/Chongqing", "Asia/Chungking")

        insert(
            "Eire",
            "4u,-34XlZ2=4v,1es3fD=4w,MdnW=d,16vG7=f,WJcQ=d,169B6=f,16Syc=d,13Cgg=f,14ldm=d,13Cgg=f,1euyI=d,W0fK=f,14ldm=d,114Vq=H,193pu=d,193pu=H,Ri3C=d,1e85a=H,WmJi=d,1e85a=H,YU48=d,193pu=H,YU48=d,16w4E=H,11roY=d,1bAKk=H,YU48=d,193pu=H,YU48=d,16w4E=H,11roY=d,193pu=H,YU48=d,193pu=H,YU48=d,16w4E=H,13YJO=d,193pu=H,YU48=d,16w4E=H,11roY=d,193pu=H,YU48=d,193pu=H,YU48=d,16w4E=H,11roY=d,193pu=H,1gFq0=d,zwHK=H,e7uXm=d,WmJi=H,1lK5G=d,YU48=H,193pu=d,TPos=H,1e85a=d,YU48=H,16w4E=d,11roY=H,16w4E=d,13YJO=H,16w4E=d,11roY=H,YU48=d,16w4E=H,11roY=d,193pu=H,YU48=d,1bAKk=H,YU48=d,16w4E=H,11roY=d,193pu=H,YU48=d,193pu=H,YU48=d,16w4E=H,11roY=d,11roY=H,1gFq0=d,Ri3C=H,1gFq0=d,TPos=H,1e85a=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1jcKQ=d,EBnq=H,1tji0=H,6qszS=d,OKIM=H,1jcKQ=d,OKIM=H,1jcKQ=d,OKIM=H,1jcKQ=d,OKIM=H,1jcKQ=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1jcKQ=d,OKIM=H,1jcKQ=d,OKIM=H,1jcKQ=d,TOso=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d,Ri3C=H,1gFq0=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1e85a=d,WmJi=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,Ri3C=H,1gFq0=d,TPos=H,1e85a=d,TPos=H,1e85a=d,TPos=H,1gFq0=d"
        )

        insert(
            "Europe/Amsterdam",
            "7h,-4EjpQM=1q,2NGP0Q=1r,TrYQ=1q,19sHe=1r,TPos=1q,193pu=1r,13YJO=1q,16w4E=1r,11roY=1q,16w4E=1r,11roY=1q,16w4E=1r,11roY=1q,13Cgg=1r,193pu=1q,1nytq=1r,Kp0c=1q,11roY=1r,16w4E=1q,1q5Og=1r,HRFm=1q,1iQhi=1r,P7ck=1q,1jcKQ=1r,OKIM=1q,1jVHW=1r,Qz6w=1q,1hKQE=1r,QcCY=1q,1i7kc=1r,PQ9q=1q,1itNK=1r,PtFS=1q,1lK5G=1r,MdnW=1q,1jzeo=1r,QVA4=1q,1hon6=1r,Qz6w=1q,1hKQE=1r,QcCY=1q,1itNK=1r,PtFS=1q,1lnC8=1r,esfK=3a,y7Bi=1k,1jcKQ=3a,OKIM=1k,1jzeo=3a,QVA4=1k,1i5s4=1,5giaY=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,YxAA=0,15n1ew=1,11roY=0,16w4E=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "America/Indiana/Knox",
            "3b,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,3m6uQ=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,Rh7y=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,TOso=3,1e91e=7,TOso=3,1e91e=7,13XNK=3,13ZFS=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=2,3bVhm=3,7upry=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,pois=7,1Izba=3,H9Ek=7,1qNPi=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=2,uOS5y=7,1e85a=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        insert(
            "America/North_Dakota/Beulah",
            "7i,-2XUXfi=9,1bnUha=b,1e796=9,TQkw=b,1e796=9,LBHj2=1t,7uY5W=1B,gOlO=9,K5ros=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,pois=b,1Izba=9,H9Ek=b,1qNPi=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=3,JG36=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        insert(
            "Africa/Accra",
            "7j,-1N3rNG=d,5H6bi=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qP4I=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qP4I=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qP4I=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qP4I=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d,1qP4I=1k,HRm0=d,1qsBa=1k,HRm0=d,1qsBa=1k,HRm0=d"
        )

        link("Atlantic/Faroe", "Atlantic/Faeroe")

        insert(
            "Mexico/BajaNorte",
            "2A,-1EvG1O=9,4gCYg=a,7lH4k=9,7kfa8=a,NGec=c,13XNK=a,mz05i=1E,749Lq=1F,wnUk=a,57dWU=c,1EWpG=a,bgCfS=c,TPos=a,1e85a=c,TPos=a,1gFq0=c,TPos=a,1e85a=c,TPos=a,1e85a=c,TPos=a,1e85a=c,TPos=a,1e85a=c,TPos=a,xh9bW=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,OLEQ=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a"
        )

        insert(
            "America/Maceio",
            "7k,-1VB3Ss=8,BUN4o=l,13r1u=8,1556w=l,13eQE=8,zB4oE=l,NiOA=8,1l18A=l,HQJi=8,1qtdS=l,IdcQ=8,1qtdS=l,wBXi=8,n0yiY=l,u4Cs=8,1XP4k=l,lnbi=8,1qPHq=l,wBXi=8,1qPHq=l,HufK=8,1qPHq=l,HQJi=8,BK7iU=l,McrS=8,1jdGU=l,EArm=8,1tJvO=l,C36w=8,1tn2g=l,C36w=8,1vUn6=l,H7Mc=8,c7aqk=l,H7Mc=8,7MaNq=l,Rh7y=8,1jdGU=l,53JC=8,25r4Q=l,JF72=8"
        )

        link("Etc/UCT", "Etc/GMT+9")

        insert(
            "Pacific/Apia",
            "7l,-2FuKAM=7m,DuuRO=4x,1lib1K=2e,25HTEQ=1y,16cpi=2e,11roY=1y,z6tW=1e,xpAI=V,13YJO=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,13YJO=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,193pu=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,13YJO=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,13YJO=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e,16w4E=V,11roY=1e"
        )

        link("GMT0", "Etc/GMT+9")

        insert(
            "America/Atka",
            "3c,-3wgI1x=3d,1887ud=21,1qznfc=2B,7uUlG=2C,gS64=21,JUTHq=14,4qsEg=15,13XNK=14,13ZFS=15,13XNK=14,13ZFS=15,16v8A=14,13ZFS=15,13XNK=14,13ZFS=15,13XNK=14,pois=15,1Izba=14,H9Ek=15,1qNPi=14,13ZFS=15,16v8A=14,11sl2=15,16v8A=14,13ZFS=15,13XNK=14,13ZFS=15,13XNK=14,13ZFS=15,13XNK=14,13ZFS=15,13XNK=14,13ZFS=15,16v8A=14,11sl2=15,16v8A=1f,bcTS=M,SLPW=O,13XNK=M,13ZFS=O,13XNK=M,13ZFS=O,13XNK=M,WnFm=O,1bzOg=M,WnFm=O,1e796=M,TQkw=O,1e796=M,TQkw=O,1e796=M,WnFm=O,1bzOg=M,WnFm=O,1bzOg=M,WnFm=O,1e796=M,TQkw=O,1e796=M,TQkw=O,1e796=M,WnFm=O,1bzOg=M,WnFm=O,1bzOg=M,WnFm=O,1bzOg=M,WnFm=O,1e796=M,TQkw=O,1e796=M,TQkw=O,1e796=M,WnFm=O,1bzOg=M,WnFm=O,1bzOg=M,WnFm=O,1e796=M,TQkw=O,1e796=M,TQkw=O,1e796=M,Mek0=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,Mek0=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,Mek0=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,Mek0=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,Mek0=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,Mek0=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,JGZa=O,1ogus=M,Mek0=O,1ogus=M"
        )

        insert(
            "Pacific/Niue",
            "7n,-2nmckI=7o,1IMrqY=4x,XgcmA=2e"
        )

        insert(
            "Australia/Lord_Howe",
            "4y,-2zZAiM=i,2XPrYU=X,1oiPC=1K,McrS=X,1oimA=1K,JF72=X,1oimA=1K,JF72=X,1oimA=1K,JF72=X,1oimA=t,OKfK=X,1gFT2=t,RhAA=X,1jddS=t,RhAA=X,1jddS=t,OKfK=X,1jddS=t,JFA4=X,1ohTy=t,JFA4=X,1ohTy=t,JFA4=X,1ohTy=t,McUU=X,1ohTy=t,JFA4=X,1ohTy=t,JFA4=X,1ohTy=t,TOVq=X,1e8yc=t,TOVq=X,1e8yc=t,TOVq=X,1e8yc=t,TOVq=X,1gFT2=t,RhAA=X,TPRu=t,1e7C8=X,1gFT2=t,TOVq=X,1e8yc=t,TOVq=X,1e8yc=t,TOVq=X,1gFT2=t,RhAA=X,1gFT2=t,TOVq=X,1e8yc=t,RhAA=X,1gFT2=t,Wmgg=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,16wxG=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,16wxG=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,16vBC=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,16wxG=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,16wxG=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t,13YgM=X,13ZcQ=t"
        )

        link("Europe/Dublin", "Eire")

        link("Pacific/Truk", "Pacific/Yap")

        insert(
            "MST7MDT",
            "9,-1Mx2Y8=b,1e796=9,TQkw=b,1e796=9,LBHj2=1t,7uY5W=1B,gOlO=9,K5ros=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,pois=b,1Izba=9,H9Ek=b,1qNPi=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9"
        )

        insert(
            "America/Monterrey",
            "7p,-1EvHTW=3,2huMNy=7,1e796=3,fSDlu=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,16x0I=7,Rh7y=3,16x0I=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3"
        )

        insert(
            "America/Nassau",
            "7q,-1ZvUAC=2,1NnpKC=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "America/Jamaica",
            "4z,-2KQyB3=2Q,L9LFK=2,28gm9H=4,1Izba=2,H9Ek=4,1qNPi=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2"
        )

        insert(
            "Asia/Bishkek",
            "7r,-1zx07S=o,d6q0o=r,1KrKjS=v,14khi=r,13ZFS=v,14khi=r,13ZFS=v,14khi=r,14m9q=v,140BW=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,13YJO=r,13YJO=v,16w4E=r,13YJO=r,TsUU=o,1jyik=r,YT84=o,194ly=r,YT84=o,194ly=r,YT84=o,194ly=r,YT84=o,194ly=r,11qsU=o,14212=r,1e796=o,TQkw=r,1e796=o,TQkw=r,1gEtW=o,RiZG=r,1gEtW=o,RiZG=r,1gEtW=o,TQkw=r,1e796=o,TQkw=r,1e796=o,TQkw=r,1gEtW=o,RiZG=r,NYus=r"
        )

        insert(
            "America/Atikokan",
            "4A,-2Aazqk=3,NIAbO=7,192tq=3,KP5zq=7,2Uzde=1j,7uZ20=1m,gNpK=2"
        )

        insert(
            "Atlantic/Stanley",
            "7s,-2KQzMo=7t,LogJG=e,Sy0de=8,11qsU=e,16x0I=8,11qsU=e,194ly=8,11qsU=e,16x0I=8,11qsU=e,16x0I=8,11qsU=e,16x0I=8,yMOA=e,1o813O=8,Rh7y=l,1gEtW=8,OLEQ=l,1jbOM=8,OLEQ=8,1gFq0=e,RiZG=8,1gEtW=e,RiZG=8,1gEtW=e,RiZG=8,1gEtW=e,RiZG=8,1jbOM=e,OLEQ=8,1jbOM=e,RiZG=8,1gEtW=e,RiZG=8,1gEtW=e,RiZG=8,1gEtW=e,RiZG=8,1gEtW=e,RiZG=8,1jbOM=e,RiZG=8,1gEtW=e,RiZG=8,1gEtW=e,RiZG=8,1gEtW=e,RiZG=8,1gEtW=e,RiZG=8,1gGm4=e,OLEQ=8,1lJ9C=e,Mek0=8,1lJ9C=e,OLEQ=8,1jbOM=e,OLEQ=8,1jbOM=e,OLEQ=8,1jbOM=e,OLEQ=8,1jbOM=e,OLEQ=8,1lJ9C=e,OLEQ=8,1jbOM=e,OLEQ=8,1jbOM=e,OLEQ=8"
        )

        link("Australia/NSW", "Australia/ACT")

        link("US/Hawaii", "Pacific/Honolulu")

        insert(
            "Indian/Mahe",
            "7u,-2bNIbW=n"
        )

        insert(
            "Asia/Aqtobe",
            "7v,-1zwZ2o=n,d6pQY=o,1KrKjS=r,14khi=r,13YJO=r,14ldm=o,13ZFS=r,14khi=o,14m9q=r,140BW=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,16w4E=o,13YJO=o,13ZFS=n,EBnq=o,pmqk=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,16w4E=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1gFq0=o,Ri3C=r,1gFq0=o,Ri3C=r,1gFq0=o,TPos=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1gFq0=o"
        )

        insert(
            "America/Sitka",
            "7w,-3wgI1x=7x,1884U8=a,1qzn15=1E,7uX9S=1F,gPhS=a,OlmlG=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,pois=c,1Izba=a,H9Ek=c,1qNPi=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=1a,beM0=p,SLPW=q,13XNK=p,13ZFS=q,13XNK=p,13ZFS=q,13XNK=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p"
        )

        insert(
            "Asia/Vladivostok",
            "7y,-1CEEcr=G,ge0kH=L,1KrKjS=t,14khi=L,13ZFS=t,14khi=L,13ZFS=t,14khi=L,14m9q=t,140BW=L,13YJO=t,13YJO=L,13YJO=t,13YJO=L,13YJO=t,13YJO=L,13YJO=t,13YJO=L,13YJO=t,13YJO=L,13YJO=t,16w4E=L,13YJO=L,13ZFS=G,EBnq=L,pmqk=t,13YJO=L,13YJO=t,13YJO=L,13YJO=t,13YJO=L,13YJO=t,13YJO=L,16w4E=t,1e85a=L,TPos=t,1e85a=L,TPos=t,1e85a=L,TPos=t,1gFq0=L,Ri3C=t,1gFq0=L,Ri3C=t,1gFq0=L,TPos=t,1e85a=L,TPos=t,1e85a=L,TPos=t,1gFq0=L,Ri3C=t,1gFq0=L,Ri3C=t,1gFq0=L,Ri3C=t,1gFq0=L,TPos=t,1e85a=L,TPos=t,1e85a=L,TPos=t,1gFq0=L,Ri3C=t,7EwUM=L"
        )

        link("Africa/Libreville", "Africa/Malabo")

        link("Africa/Maputo", "Africa/Kigali")

        link("Zulu", "Etc/GMT+9")

        insert(
            "America/Kentucky/Monticello",
            "7z,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,MdoS4=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,pois=7,1Izba=3,H9Ek=7,1qNPi=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=2,TPos=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        link("Africa/Ouagadougou", "Atlantic/St_Helena")

        insert(
            "Africa/El_Aaiun",
            "7A,-1eSPOE=s,1siQwg=g,69ag=h,xkUo=g,1AZ2M=h,Smyc=g,1rcaY=h,nbz2=g,11HmSc=h,xkUo=g,1AZ2M=h,tlFm=g,1u5Zm=h,zvLG=g,1oimA=h,H7Mc=g,1B0UU=h,tJ4Y=g,beM0=h,eRxu=g,1e85a=h,pnmo=g,ckcE=h,shaM=g,TPos=h,wCTm=g,cGGc=h,uOvC=g,TPos=h,rUHe=g,cGGc=h,zwHK=g,TPos=h,pnmo=g,cGGc=h,EBnq=g,Ri3C=h,kiGI=g,fe12=h,H8Ig=g,Ri3C=h,hLlS=g,cGGc=h,MdnW=g,TPos=h,cGGc=g,cGGc=h,OKIM=g,TPos=h,7C0w=g,cGGc=h,TPos=g,TPos=h,54FG=g,cGGc=h,YU48=g,16w4E=h,11roY=g,11roY=h,16w4E=g,YU48=h,193pu=g,WmJi=h,1bAKk=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1bAKk=g,WmJi=h,16w4E=g,11roY=h,1gFq0=g"
        )

        link("America/Coral_Harbour", "America/Atikokan")

        insert(
            "Pacific/Marquesas",
            "7B,-1YgDck=1H"
        )

        link("Brazil/West", "America/Manaus")

        link("America/Aruba", "America/Curacao")

        insert(
            "America/North_Dakota/Center",
            "7C,-2XUXfi=9,1bnUha=b,1e796=9,TQkw=b,1e796=9,LBHj2=1t,7uY5W=1B,gOlO=9,K5ros=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,pois=b,1Izba=9,H9Ek=b,1qNPi=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=3,WmJi=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        link("America/Cayman", "America/Panama")

        link("Asia/Ulaanbaatar", "Asia/Ulan_Bator")

        insert(
            "Asia/Baghdad",
            "4B,-2KQGag=7D,XNbzS=J,2dnTQA=n,TrYQ=J,13Dck=n,14GKQ=J,14m9q=n,14khi=J,13ZFS=n,13Dck=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,16w4E=J,14n5u=n,14ldm=J,14ldm=n,14ldm=J,13YJO=n,14ldm=J,13YJO=n,14ldm=J,13YJO=n,14ldm=J,14ldm=n,14ldm=J,13YJO=n,14ldm=J,13YJO=n,14ldm=J,13YJO=n,14ldm=J,14ldm=n,14ldm=J,13YJO=n,14ldm=J,13YJO=n,14ldm=J,13YJO=n,14ldm=J,14ldm=n,14ldm=J,13YJO=n,14ldm=J,13YJO=n,14ldm=J,13YJO=n,14ldm=J"
        )

        link("GMT+0", "Etc/GMT+9")

        link("Europe/San_Marino", "Europe/Rome")

        insert(
            "America/Indiana/Tell_City",
            "7E,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,1e91e=7,TOso=3,e2rdK=7,TOso=3,1e91e=7,TOso=3,1gEtW=7,RiZG=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,16v8A=3,13ZFS=7,Rh7y=3,1gGm4=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=2,aGjMQ=4,13XNK=2,13ZFS=4,13XNK=2,1dGboQ=7,1e85a=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        link("America/Tijuana", "Mexico/BajaNorte")

        link("Pacific/Saipan", "Pacific/Guam")

        link("Africa/Douala", "Africa/Malabo")

        insert(
            "America/Ojinaga",
            "7F,-1EvGXS=9,bCk2A=3,7kfa8=9,YU48=3,T6rm=9,14m9q=3,2cIAus=7,1bzOg=3,WnFm=7,1bzOg=3,WoBq=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,16x0I=b,Rh7y=9,16x0I=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,OLEQ=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9"
        )

        insert(
            "America/Chihuahua",
            "7G,-1EvGXS=9,bCk2A=3,7kfa8=9,YU48=3,T6rm=9,14m9q=3,2cIAus=7,1bzOg=3,WnFm=7,1bzOg=3,WoBq=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,16x0I=b,Rh7y=9,16x0I=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9"
        )

        insert(
            "Asia/Hovd",
            "7H,-2dzXkM=r,2uFaiM=v,bcAcE=A,14khi=v,14m9q=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,16v8A=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,16x0I=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,5wgHS=A,TOso=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,13XNK=v,13ZFS=A,16v8A=v,i8cPC=A,13VVC=v,141y0=A,13VVC=v"
        )

        link("America/Anchorage", "US/Alaska")

        link("Chile/EasterIsland", "Pacific/Easter")

        link("America/Halifax", "Canada/Atlantic")

        insert(
            "Antarctica/Rothera",
            "1s,eLJRe=8"
        )

        link("America/Indiana/Indianapolis", "America/Fort_Wayne")

        link("US/Mountain", "America/Denver")

        insert(
            "Asia/Damascus",
            "7I,-1IMQaI=5,DbJK=6,YT84=5,194ly=6,YT84=5,194ly=6,YT84=5,194ly=6,11qsU=5,1klPby=6,UaVW=5,1eRYk=6,T5vi=5,1fAVq=6,TrYQ=5,1eRYk=6,T5vi=5,1cH72=6,VZjG=5,1eRYk=6,TrYQ=5,1ferS=6,TrYQ=5,1eRYk=6,TrYQ=5,1eRYk=6,TrYQ=5,1eRYk=6,TrYQ=5,1ferS=6,TrYQ=5,1eRYk=6,TrYQ=5,1eRYk=6,TrYQ=5,1eRYk=6,TrYQ=5,1ferS=6,TrYQ=5,1eRYk=6,IzGo=5,1pKgM=6,IzGo=5,9Pq4U=6,11qsU=5,17fXO=6,11qsU=5,2WmEU=6,1nb3O=5,PR5u=6,1qrlK=5,NjKE=6,1lmG4=5,SKTS=6,14GKQ=5,13ZFS=6,13XNK=5,14khi=6,14khi=5,16Tug=6,11MWs=5,11OOA=6,14khi=5,16axa=6,14khi=5,13ZFS=6,14khi=5,14m9q=6,14khi=5,13Dck=6,14GKQ=5,13gIM=6,153eo=5,13ZFS=6,14khi=5,14m9q=6,14khi=5,13ZFS=6,14khi=5,13ZFS=6,14khi=5,13ZFS=6,14khi=5,14m9q=6,14khi=5,13ZFS=6,14khi=5,13ZFS=6,113Zm=5,16x0I=6,1gEtW=5,TQkw=6,1etCE=5,QWw8=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5"
        )

        insert(
            "America/Argentina/San_Luis",
            "7J,-2Ax4y8=1v,SscjO=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,Smyc=e,1fYl2=8,NEm4=e,xmMw=8,hOeKk=8,T6rm=8,93UI0=e,jX9e=8,7kee4=l,7Xy0=8,hpOo=e,1gGm4=8,Rh7y=e,1gGm4=8"
        )

        link("America/Santiago", "Chile/Continental")

        insert(
            "Asia/Baku",
            "7K,-1zwYA4=J,18733u=n,Pr7B6=o,14khi=n,13ZFS=o,14khi=n,13ZFS=o,14khi=n,14m9q=o,140BW=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,16w4E=n,13YJO=n,13ZFS=J,13YJO=n,13YJO=n,7uqnC=o,1e85a=n,TOso=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1e85a=n"
        )

        insert(
            "America/Argentina/Ushuaia",
            "7L,-2Ax4qA=1v,Ssccg=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=8,1lL1K=l,McrS=8,1lL1K=l,McrS=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,93yes=e,7CWA=8,7wUUg=l,rTLa=8"
        )

        insert(
            "Atlantic/Reykjavik",
            "4C,-28pJpC=s,jw5tm=y,1q6Kk=s,IdcQ=y,1zx8A=s,yMOA=y,1zx8A=s,2RCAE=y,ysda=s,C7Epq=y,140BW=s,H9Ek=y,1tla8=s,H8Ig=y,1qOLm=s,JG36=y,1lK5G=s,MdnW=y,1lK5G=s,MdnW=y,1lK5G=s,MdnW=y,1ohqw=s,JG36=y,1ohqw=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1e85a=s,TPos=y,1bAKk=s,WmJi=y,1e85a=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1e85a=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1e85a=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1bAKk=s,WmJi=y,1e85a=s,WmJi=d"
        )

        link("Africa/Brazzaville", "Africa/Malabo")

        link("Africa/Porto-Novo", "Africa/Malabo")

        insert(
            "America/La_Paz",
            "7M,-2KQz8w=7N,1revbW=7O,VgmA=e"
        )

        insert(
            "Antarctica/DumontDUrville",
            "1s,-N7zO0=L,aKx4Q=1s,afEOY=L"
        )

        link("Asia/Taipei", "ROC")

        link("Antarctica/South_Pole", "Antarctica/McMurdo")

        insert(
            "Asia/Manila",
            "7P,-4iXe80=7Q,1S5dG8=A,1i2fAc=G,xkUo=A,bcfBe=G,5lH8I=A,kamGs=G,sZbO=A,OFiyQ=G,14khi=A"
        )

        link("Asia/Bangkok", "Asia/Phnom_Penh")

        link("Africa/Dar_es_Salaam", "Africa/Nairobi")

        link("Poland", "Europe/Warsaw")

        insert(
            "Atlantic/Madeira",
            "7R,-2XFh0Y=7S,XNbzO=s,9wTMs=y,NjKE=s,HufK=y,1kEF2=s,O1LG=y,1kibu=s,NFi8=y,1kEF2=s,O1LG=y,1kEF2=s,NFi8=y,1kEF2=s,5lI4M=y,13Cgg=s,3do7C=y,YU48=s,16w4E=y,11roY=s,193pu=y,11roY=s,193pu=y,YU48=s,3h0T6=y,YU48=s,13YJO=y,13YJO=s,3etyg=y,13YJO=s,11roY=y,16w4E=s,193pu=y,YU48=s,13YJO=y,13YJO=s,11roY=y,16w4E=s,193pu=y,1gFq0=s,zwHK=y,1jcKQ=s,13YJO=y,14ldm=s,W0fK=y,fd4Y=2D,EBnq=y,pois=s,OKIM=y,cFK8=2D,MdnW=y,mQXC=s,MdnW=y,fd4Y=2D,JG36=y,mQXC=s,MdnW=y,fd4Y=2D,JG36=y,mQXC=s,WmJi=y,13YJO=s,141y0=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,3bWdq=y,16w4E=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,16w4E=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,16w4E=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=g,ns2Mo=h,13YJO=g,16w4E=h,13YJO=g,13YJO=h,13ZFS=g,13XNK=h,13ZFS=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13ZFS=h,13XNK=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,16w4E=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g"
        )

        insert(
            "Antarctica/Palmer",
            "1s,-aFYfm=8,lqVy=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,h5jws=e,WK8U=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,13XNK=e,13ZFS=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,16x0I=8,11qsU=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,YT84=e,194ly=8,TOso=e,194ly=8,16v8A=e,16x0I=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,YT84=e,194ly=8,TOso=e,1e91e=8,11qsU=e,16x0I=8,1e796=e,C4YE=8,1tla8=e,JGZa=8,1ogus=e,Mek0=8,1lJ9C=e,Mek0=8,3BiDK=e,x0iY=8,EArm=8"
        )

        insert(
            "America/Thunder_Bay",
            "7T,-2Aazzu=3,w1UMY=2,16zlS0=1R,7uZY4=1S,gMtG=2,QtjPi=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,3bX9u=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        link("GMT-0", "Etc/GMT+9")

        link("Africa/Addis_Ababa", "Africa/Nairobi")

        insert(
            "Asia/Yangon",
            "4D,-36d2mX=4E,1nq8so=1A,LGKXB=G,6q0WY=1A"
        )

        insert(
            "Europe/Uzhgorod",
            "7U,-2JfGFW=0,1HI8xG=1,5wAne=0,Ri3C=1,16w4E=0,13YJO=1,1cDmM=0,1rcaY=K,1emylO=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,1Dvry=0,1B0UU=5,27TJm=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,142u4=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        link("Brazil/DeNoronha", "America/Noronha")

        insert(
            "Asia/Ashkhabad",
            "4F,-1zwZ76=n,d6pVG=o,1KrKjS=r,14khi=o,13ZFS=r,14khi=o,13ZFS=r,14khi=o,14m9q=r,140BW=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,16w4E=o,13YJO=o,13ZFS=n,EBnq=o"
        )

        link("Etc/Zulu", "Etc/GMT+9")

        insert(
            "America/Indiana/Marengo",
            "7V,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,bUtK8=7,TOso=3,5u3Ys=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=2,h4cdG=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,pois=7,1IA7e=2,H8Ig=4,1qNPi=2,12ZQFW=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "America/Punta_Arenas",
            "7W,-2KQyXO=1X,GL9gu=I,dP0V4=1X,4GntA=e,1IzrQ=1X,hrMNM=e,1fcQq=I,TtQY=e,1eQ6c=I,TtQY=e,1eQ6c=I,TtQY=e,1eQ6c=I,TtQY=e,1fczK=I,TtQY=e,kOzIc=I,m80w=e,9XJao=I,iuiY=e,JOKxa=8,Rh7y=e,1oimA=8,JF72=e,194ly=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1bBGo=8,WlNe=e,1gGm4=8,Rh7y=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,13XNK=e,13ZFS=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,16x0I=8,11qsU=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,YT84=e,194ly=8,TOso=e,194ly=8,16v8A=e,16x0I=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,Rh7y=e,1gGm4=8,TOso=e,1e91e=8,TOso=e,1e91e=8,TOso=e,1gGm4=8,Rh7y=e,1gGm4=8,YT84=e,194ly=8,TOso=e,1e91e=8,11qsU=e,16x0I=8,1e796=e,C4YE=8,1tla8=e,JGZa=8,1ogus=e,Mek0=8,1lJ9C=e,Mek0=8,3BiDK=e,x0iY=8,EArm=8"
        )

        insert(
            "America/Creston",
            "7X,-2XFaNm=9,17W9JG=a,3yNb2=9"
        )

        link("America/Mexico_City", "Mexico/General")

        insert(
            "Antarctica/Vostok",
            "1s,-pIKvm=r"
        )

        link("Asia/Jerusalem", "Israel")

        insert(
            "Europe/Andorra",
            "7Y,-2nmn2k=g,1zH4Uk=0,1kdQHu=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        link("US/Samoa", "Pacific/Pago_Pago")

        link("PRC", "Asia/Chungking")

        link("Asia/Vientiane", "Asia/Phnom_Penh")

        insert(
            "Pacific/Kiritimati",
            "7Z,-2nmd7q=80,2IaXL2=1y,wzCrm=1e"
        )

        insert(
            "America/Matamoros",
            "81,-1EvHTW=3,2huMNy=7,1e796=3,fSDlu=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,16x0I=7,Rh7y=3,16x0I=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,OLEQ=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        insert(
            "America/Blanc-Sablon",
            "82,-2XFevi=k,1bddoE=m,192tq=k,NJEME=26,7v0U8=27,gLxC=k"
        )

        link("Asia/Riyadh", "Asia/Aden")

        link("Iceland", "Atlantic/Reykjavik")

        link("Pacific/Pohnpei", "Pacific/Ponape")

        insert(
            "Asia/Ujung_Pandang",
            "4G,-1IMVmo=4H,rpweQ=A,jNSa4=G,7Jf6U=2G"
        )

        insert(
            "Atlantic/South_Georgia",
            "83,-2KQB6U=l"
        )

        link("Europe/Lisbon", "Portugal")

        link("Asia/Harbin", "Asia/Chungking")

        insert(
            "Europe/Oslo",
            "3e,-2AaFOA=0,JFHi4=1,LsyI=0,OXLVK=1,4KMh2=0,Ri3C=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,sJ5te=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,1gFq0=1,Ri3C=0,v466A=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "Asia/Novokuznetsk",
            "84,-1zxnoc=r,d6MkE=v,1KrKjS=A,14khi=v,13ZFS=A,14khi=v,13ZFS=A,14khi=v,14m9q=A,140BW=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,16w4E=v,13YJO=v,13ZFS=r,EBnq=v,pmqk=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,16w4E=A,1e85a=v,TPos=A,1e85a=v,TPos=A,1e85a=v,TPos=A,1gFq0=v,Ri3C=A,1gFq0=v,Ri3C=A,1gFq0=v,TPos=A,1e85a=v,TPos=A,1e85a=v,TPos=A,1gFq0=v,Ri3C=A,1gFq0=v,Ri3C=A,1gFq0=v,Ri3C=A,1gFq0=v,TPos=A,1e85a=v,TPos=A,1e85a=v,TPos=v,1gGm4=r,Ri3C=v"
        )

        insert(
            "CST6CDT",
            "3,-1Mx3Uc=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,K5ros=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,pois=7,1Izba=3,H9Ek=7,1qNPi=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        insert(
            "Atlantic/Canary",
            "85,-1Eaorm=s,Qv8bu=g,19A0ve=h,11sl2=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,16w4E=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g"
        )

        link("America/Knox_IN", "America/Indiana/Knox")

        link("Asia/Kuwait", "Asia/Aden")

        insert(
            "Pacific/Efate",
            "86,-1ZNVhy=t,2t7P40=E,13XNK=t,1eRYk=E,T5vi=t,16x0I=E,11qsU=t,16x0I=E,13XNK=t,13ZFS=E,13XNK=t,13ZFS=E,13XNK=t,13ZFS=E,13XNK=t,13ZFS=E,13XNK=t,16x0I=E,H7Mc=t,1AZ2M=E,wYqQ=t"
        )

        link("Africa/Lome", "Atlantic/St_Helena")

        insert(
            "America/Bogota",
            "87,-2Xf78c=88,13yh0Y=I,2FooNi=e,1XNcc=I"
        )

        insert(
            "America/Menominee",
            "89,-2U051b=3,17t16Z=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,1e91e=7,TOso=3,FMZ6o=7,16v8A=3,5jUD6=2,8ymje=7,13YJO=3,pois=7,1Izba=3,H9Ek=7,1qNPi=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        link("America/Adak", "America/Atka")

        insert(
            "Pacific/Norfolk",
            "8a,-2nmxqE=8b,1IMrqw=1K,ORZTG=8c,JF72=1K,1oGOOs=t"
        )

        insert(
            "Europe/Kirov",
            "8d,-1JRvB6=J,nqXlK=n,1KrKjS=o,14khi=n,13ZFS=o,14khi=n,13ZFS=o,14khi=n,14m9q=o,140BW=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=n,13ZFS=J,13YJO=n,16w4E=J,13YJO=n,27Wxy=n,13ZFS=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,16w4E=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,7EwUM=J"
        )

        insert(
            "America/Resolute",
            "1s,-LHQti=3,BHiaQ=43,16w4E=3,uWvYc=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,16v8A=3,11sl2=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,13ZFS=7,13XNK=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=2,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=2,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        insert(
            "Pacific/Tarawa",
            "8e,-2nmxKc=E"
        )

        link("Africa/Kampala", "Africa/Nairobi")

        insert(
            "Asia/Krasnoyarsk",
            "8f,-1IL5jU=r,mkugm=v,1KrKjS=A,14khi=v,13ZFS=A,14khi=v,13ZFS=A,14khi=v,14m9q=A,140BW=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,16w4E=v,13YJO=v,13ZFS=r,EBnq=v,pmqk=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,13YJO=A,13YJO=v,16w4E=A,1e85a=v,TPos=A,1e85a=v,TPos=A,1e85a=v,TPos=A,1gFq0=v,Ri3C=A,1gFq0=v,Ri3C=A,1gFq0=v,TPos=A,1e85a=v,TPos=A,1e85a=v,TPos=A,1gFq0=v,Ri3C=A,1gFq0=v,Ri3C=A,1gFq0=v,Ri3C=A,1gFq0=v,TPos=A,1e85a=v,TPos=A,1e85a=v,TPos=A,1gFq0=v,Ri3C=A,7EwUM=v"
        )

        link("Greenwich", "Etc/GMT+9")

        insert(
            "America/Edmonton",
            "4I,-2bgbNC=9,oOdva=b,192tq=9,YV0c=b,fW24=9,1X67e=b,16v8A=9,11sl2=b,TOso=9,1gGm4=b,Rh7y=9,1gGm4=b,TOso=9,Ddtp6=1t,7uY5W=1B,gOlO=9,3m6uQ=b,TOso=9,FPwre=b,13XNK=9,3bX9u=b,13XNK=9,5mrXW=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9"
        )

        link("Europe/Podgorica", "Europe/Skopje")

        link("Australia/South", "Australia/Adelaide")

        insert(
            "Canada/Central",
            "4J,-2Q6OfO=3,ZrpwM=7,Rh7y=3,3m8mY=7,192tq=3,DCuhW=7,McrS=3,9kY2Q=1j,7uZ20=1m,gNpK=3,1jdGU=7,TOso=3,194ly=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1h2PC=7,T5vi=3,1evuM=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,13XNK=3,13ZFS=7,TOso=3,5wBji=7,Rh7y=3,5wBji=7,16w4E=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,16w4E=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,16w4E=3,11roY=7,16w4E=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,16w4E=3,11roY=7,16w4E=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,13YJO=7,13YJO=3,WmJi=7,1bAKk=3,WmJi=7,1e85a=3,TPos=7,1e85a=3,TPos=7,1e85a=3,WmJi=7,1bAKk=3,WmJi=7,1bAKk=3,WmJi=7,1e85a=3,TPos=7,1e85a=3,TPos=7,1e85a=3,WmJi=7,1bAKk=3,WmJi=7,1bAKk=3,WmJi=7,1bAKk=3,WmJi=7,1e85a=3,TPos=7,1e85a=3,TPos=7,1e85a=3,WmJi=7,1bAKk=3,WmJi=7,1bAKk=3,WmJi=7,1e85a=3,TPos=7,1e85a=3,TPos=7,1e796=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        link("Africa/Bujumbura", "Africa/Kigali")

        insert(
            "America/Santo_Domingo",
            "8g,-2KQz1K=8h,1umgVW=2,19Icpy=4,HQJi=2,5G1Hy=1T,GLLG=2,1rbHW=1T,vwZG=2,1EXOM=1T,tIBW=2,1EeRG=1T,urz2=2,1DvUA=1T,uO2A=2,1D9r2=k,TxE2c=2,cGGc=k"
        )

        insert(
            "US/Eastern",
            "4K,-2XUZ7q=2,1bnUha=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1gEtW=2,11sl2=4,TOso=2,1gGm4=4,Rh7y=2,1gGm4=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1gGm4=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1gGm4=4,Rh7y=2,1gGm4=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1gGm4=4,Rh7y=2,1gGm4=4,TOso=2,1e91e=4,TOso=2,MANy=1R,7uZY4=1S,gMtG=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1gGm4=4,Rh7y=2,1gGm4=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,pois=4,1Izba=2,H9Ek=4,1qNPi=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "Europe/Minsk",
            "8i,-36cY5i=8j,1wG0TK=5,d6pSg=K,nx9kc=1,2Sqe4=0,Ri3C=1,16w4E=0,13YJO=1,wWyI=K,1gtrkQ=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,3etyg=6,13ZFS=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=J"
        )

        link("Pacific/Auckland", "Antarctica/McMurdo")

        insert(
            "Africa/Casablanca",
            "8k,-1VZnz6=g,TgAe0=h,oDte=g,zxDO=h,ceKyI=g,9JYVG=h,OJMI=g,zrsLC=h,Hj0Y=g,en6o0=h,oZWM=g,3yqHu=h,xkUo=g,1AZ2M=h,Smyc=g,1rcaY=h,nbz2=g,bZypO=0,3PNHG=g,LS0KI=h,xkUo=g,1AZ2M=h,tlFm=g,1u5Zm=h,zvLG=g,1oimA=h,H7Mc=g,1B0UU=h,tJ4Y=g,beM0=h,eRxu=g,1e85a=h,pnmo=g,ckcE=h,shaM=g,TPos=h,wCTm=g,cGGc=h,uOvC=g,TPos=h,rUHe=g,cGGc=h,zwHK=g,TPos=h,pnmo=g,cGGc=h,EBnq=g,Ri3C=h,kiGI=g,fe12=h,H8Ig=g,Ri3C=h,hLlS=g,cGGc=h,MdnW=g,TPos=h,cGGc=g,cGGc=h,OKIM=g,TPos=h,7C0w=g,cGGc=h,TPos=g,TPos=h,54FG=g,cGGc=h,YU48=g,16w4E=h,11roY=g,11roY=h,16w4E=g,YU48=h,193pu=g,WmJi=h,1bAKk=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1bAKk=g,WmJi=h,16w4E=g,11roY=h,1gFq0=g"
        )

        insert(
            "America/Glace_Bay",
            "8l,-2kgaBK=k,xO9v6=m,192tq=k,NJEME=26,7v0U8=27,gLxC=k,gaoHm=m,TOso=k,DHyXC=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k"
        )

        insert(
            "Canada/Eastern",
            "3f,-2AaAbG=2,NIA16=4,192tq=2,UasU=4,1dL8A=2,16ySQ=4,Rffq=2,1lMTS=4,IzGo=2,1pnNe=4,JF72=2,1oimA=4,JF72=2,1lL1K=4,OJMI=2,1jdGU=4,OJMI=2,1jdGU=4,OJMI=2,1jdGU=4,Rh7y=2,1gGm4=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1gGm4=4,Rh7y=2,1gGm4=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1gGm4=4,Rh7y=2,1gGm4=4,3OmJy=1R,7uZY4=1S,gMtG=2,1e91e=4,TOso=2,1e796=4,TOso=2,1e91e=4,TOso=2,1e91e=4,1gEtW=2,TScE=4,1e796=2,TQkw=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1e91e=4,TOso=2,1gGm4=4,TOso=2,1e91e=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        insert(
            "Asia/Qatar",
            "4L,-1IMR7G=n,1NWxJ6=J"
        )

        insert(
            "Europe/Kiev",
            "8m,-36cYgI=8n,1wG0Tu=5,d6q3W=K,o1Bmg=1,2nYc0=0,Ri3C=1,16w4E=0,bVQY=K,1hSqMo=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,zvLG=6,2EYIE=5,13WRG=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,142u4=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        insert(
            "Singapore",
            "4M,-2nmtqt=3g,9qog0=v,WUO17=29,6oXy8=29,c6qxa=1G,YTUs=G,7CI40=1G,1fx6WI=A"
        )

        insert(
            "Asia/Magadan",
            "8o,-1zx4SQ=L,d6q52=t,1KrKjS=E,14khi=t,13ZFS=E,14khi=t,13ZFS=E,14khi=t,14m9q=E,140BW=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,16w4E=t,13YJO=t,13ZFS=L,EBnq=t,pmqk=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,16w4E=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1gFq0=t,Ri3C=E,1gFq0=t,Ri3C=E,1gFq0=t,TPos=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1gFq0=t,Ri3C=E,1gFq0=t,Ri3C=E,1gFq0=t,Ri3C=E,1gFq0=t,TPos=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1gFq0=t,Ri3C=E,7EwUM=L,3bY5y=t"
        )

        insert(
            "America/Port-au-Prince",
            "8p,-2KQySk=8q,VNnOI=2,2hyz6k=4,11qsU=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WoBq=4,1e85a=2,TPos=4,1e85a=2,TPos=4,1e85a=2,WmJi=4,1bAKk=2,WmJi=4,1bAKk=2,WmJi=4,1e85a=2,TPos=4,1e85a=2,TPos=4,1e85a=2,WmJi=4,1bAKk=2,WmJi=4,1bAKk=2,fSBtm=4,1e796=2,TQkw=4,1e796=2,bsAV2=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,2UbNC=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        link("Europe/Belfast", "Europe/London")

        link("America/St_Barthelemy", "America/Marigot")

        link("Asia/Ashgabat", "Asia/Ashkhabad")

        link("Africa/Luanda", "Africa/Malabo")

        insert(
            "America/Nipigon",
            "8r,-2AazDi=2,NIzsI=4,192tq=2,KP5zq=4,2Uzde=1R,7uZY4=1S,gMtG=2,Z1H4A=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,16v8A=2,11sl2=4,16v8A=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,13ZFS=4,13XNK=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        link("Atlantic/Jan_Mayen", "Europe/Oslo")

        link("Brazil/Acre", "America/Porto_Acre")

        link("Asia/Muscat", "Asia/Dubai")

        link("Asia/Bahrain", "Asia/Qatar")

        insert(
            "Europe/Vilnius",
            "8s,-36cXWA=2K,1h1aRC=8t,5US7K=0,1C45O=5,wftK=0,GjYti=K,1TN16=1,2TS8g=0,Ri3C=1,16w4E=0,13YJO=1,HsnC=K,1giVvW=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=6,13ZFS=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TQkw=1,1e85a=0,TPos=1,1gFq0=5,7hHPi=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        insert(
            "America/Fortaleza",
            "8u,-1VB3HG=8,BUMTC=l,13r1u=8,1556w=l,13eQE=8,zB4oE=l,NiOA=8,1l18A=l,HQJi=8,1qtdS=l,IdcQ=8,1qtdS=l,wBXi=8,n0yiY=l,u4Cs=8,1XP4k=l,lnbi=8,1qPHq=l,wBXi=8,1qPHq=l,HufK=8,1qPHq=l,HQJi=8,BK7iU=l,McrS=8,1jdGU=l,EArm=8,1tJvO=l,C36w=8,1tn2g=l,C36w=8,1vUn6=l,H7Mc=8,kAsZW=l,Rh7y=8,1jdGU=l,53JC=8,25r4Q=l,JF72=8"
        )

        link("Etc/GMT0", "Etc/GMT+9")

        link("US/East-Indiana", "America/Fort_Wayne")

        insert(
            "America/Hermosillo",
            "8v,-1EvGXS=9,bCk2A=3,7kfa8=9,YU48=3,T6rm=9,14m9q=3,lugwg=9,emJUs=a,ILSa4=9,U5IPK=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9"
        )

        insert(
            "America/Cancun",
            "8w,-1EvHTW=3,245u6Y=2,uw2f6=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,H7Mc=7,usY8=3,WnFm=7,1e796=3,TQkw=7,1e796=3,16x0I=7,Rh7y=3,16x0I=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,zxDO=2"
        )

        link("Africa/Maseru", "Africa/Mbabane")

        insert(
            "Pacific/Kosrae",
            "8x,-2nmx7m=t,2mP0Yc=E,10tcUU=t"
        )

        link("Africa/Kinshasa", "Africa/Malabo")

        insert(
            "Asia/Kathmandu",
            "4N,-1IMTes=1Q,2gXpfS=4O"
        )

        link("Asia/Seoul", "ROK")

        link("Australia/Sydney", "Australia/ACT")

        insert(
            "America/Lima",
            "8y,-2KQyA4=8z,DEEdy=I,10QMHi=e,wBXi=I,12bi8=e,13XNK=I,13ZFS=e,13XNK=I,1zL4Zy=e,wBXi=I,1BHZS=e,wBXi=I,5SInK=e,wBXi=I,812kU=e,wBXi=I"
        )

        link("Australia/LHI", "Australia/Lord_Howe")

        link("America/St_Lucia", "America/Marigot")

        insert(
            "Europe/Madrid",
            "8A,-2nmmWs=g,AUYes=h,115Ru=g,13XNK=h,14m9q=g,9FBkY=h,100qQ=g,3gZX2=h,YV0c=g,16v8A=h,11sl2=g,193pu=h,11roY=g,192tq=h,YV0c=g,gr2Ks=h,Dapi=g,13XNK=h,a8pi=1C,UbS0=h,2aad2=g,WlNe=0,4xFn2=1,HSBq=0,1l0cw=1,YV0c=0,192tq=1,YV0c=0,192tq=1,YV0c=0,192tq=1,YV0c=0,5wzra=1,TQkw=0,Qodhu=1,11sl2=0,16v8A=1,11sl2=0,11qsU=1,13ZFS=0,16v8A=1,11sl2=0,16xWM=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

        insert(
            "America/Bahia_Banderas",
            "8B,-1EvGXS=9,bCk2A=3,7kfa8=9,YU48=3,T6rm=9,14m9q=3,lugwg=9,emJUs=a,ILSa4=9,U5IPK=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,16x0I=b,Rh7y=9,16x0I=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=7,1e6d2=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3"
        )

        link("America/Montserrat", "America/Marigot")

        insert(
            "Asia/Brunei",
            "8C,-1vCShC=1G,eBAFe=A"
        )

        link("America/Santa_Isabel", "Mexico/BajaNorte")

        link("Canada/Mountain", "America/Edmonton")

        insert(
            "America/Cambridge_Bay",
            "1s,-1IMNUc=9,LdwRO=1t,7uY5W=1B,gOlO=9,FMXeg=48,16w4E=9,uWvYc=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=3,TPos=7,1e796=2,2vsI=3,RlNS=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,JGZa=b,1ogus=9,Mek0=b,1ogus=9"
        )

        insert(
            "Asia/Colombo",
            "8D,-36d1lG=8E,TwxFm=1Q,1eUinO=r,1oDr2=1A,6FFbO=1Q,1K4Uik=1A,TOVq=r,kdCvm=1Q"
        )

        link("Australia/West", "Australia/Perth")

        link("Indian/Antananarivo", "Africa/Nairobi")

        link("Australia/Brisbane", "Australia/Queensland")

        link("Indian/Mayotte", "Africa/Nairobi")

        link("US/Indiana-Starke", "America/Indiana/Knox")

        link("Asia/Urumqi", "Asia/Kashgar")

        link("US/Aleutian", "America/Atka")

        insert(
            "Europe/Volgograd",
            "4B,-1IM7J2=J,mlztG=n,1KrKjS=o,14khi=n,13ZFS=o,14khi=n,13ZFS=o,14khi=n,14m9q=o,140BW=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=n,13ZFS=J,13YJO=n,13YJO=J,13YJO=n,16w4E=J,13YJO=n,27Wxy=n,13ZFS=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,16w4E=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,7EwUM=J"
        )

        link("America/Lower_Princes", "America/Curacao")

        link("America/Vancouver", "Canada/Pacific")

        link("Africa/Blantyre", "Africa/Kigali")

        link("America/Rio_Branco", "America/Porto_Acre")

        insert(
            "America/Danmarkshavn",
            "8F,-1Q6Fqw=8,2c1umc=l,11nEI=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,16w4E=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,16w4E=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,13YJO=l,13YJO=8,zV3q=d"
        )

        link("America/Detroit", "US/Michigan")

        insert(
            "America/Thule",
            "8G,-1Q6Ciw=k,2ztxKQ=m,13XNK=k,13ZFS=m,13XNK=k,16x0I=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k"
        )

        link("Africa/Lusaka", "Africa/Kigali")

        insert(
            "Asia/Hong_Kong",
            "4P,-2fbFNM=11,1fMmtk=13,13XNK=11,v8E0=1z,7X1dK=11,1gJDi=13,1jyik=11,Mek0=13,1wBs4=11,IY24=13,13XNK=11,TQkw=13,1e796=11,TQkw=13,1e796=11,TQkw=13,1e796=11,WnFm=13,1bdkI=11,WK8U=13,1e796=11,OLEQ=13,1jbOM=11,OLEQ=13,1lJ9C=11,Mek0=13,1lJ9C=11,OLEQ=13,1jbOM=11,OLEQ=13,1jbOM=11,OLEQ=13,1jbOM=11,OLEQ=13,1lJ9C=11,Mek0=13,1lJ9C=11,Mek0=13,1lJ9C=11,OLEQ=13,1jbOM=11,OLEQ=13,1jbOM=11,YV0c=13,13XNK=11,13ZFS=13,13XNK=11,13ZFS=13,16v8A=11,13ZFS=13,13XNK=11,13ZFS=13,13XNK=11,13ZFS=13,13XNK=11,13ZFS=13,13XNK=11,13ZFS=13,16v8A=11,13ZFS=13,13XNK=11,pois=13,1Izba=11,13ZFS=13,13XNK=11,13ZFS=13,13XNK=11,5u3Ys=13,WlNe=11"
        )

        insert(
            "Iran",
            "4Q,-1Rkvpu=4R,124yre=Y,15Z5cY=n,OKfK=o,1fz3i=n,q7fy=Y,sE7m=Z,13XNK=Y,14ICY=Z,15pHW=Y,mErew=Z,PsJO=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,5kh6E=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13ZFS=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y,13Dck=Z,14GKQ=Y"
        )

        insert(
            "America/Argentina/La_Rioja",
            "8H,-2Ax4wc=1v,SschS=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=8,1lL1K=l,LtuM=e,ojNS=8,YaaY=l,McrS=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,94hby=e,6TZu=8,7wUUg=l,rTLa=8"
        )

        link("Africa/Dakar", "Atlantic/St_Helena")

        link("America/Tortola", "America/Marigot")

        insert(
            "America/Porto_Velho",
            "8I,-1VB27m=e,BUMfm=8,13r1u=e,1556w=8,13eQE=e,zB4oE=8,NiOA=e,1l18A=8,HQJi=e,1qtdS=8,IdcQ=e,1qtdS=8,wBXi=e,n0yiY=8,u4Cs=e,1XP4k=8,lnbi=e,1qPHq=8,wBXi=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,BK7iU=8,McrS=e,1jdGU=8,EArm=e,1tJvO=8,C36w=e"
        )

        insert(
            "Asia/Sakhalin",
            "8J,-2ds22k=G,1nremQ=t,1e1Tby=E,14khi=t,13ZFS=E,14khi=t,13ZFS=E,14khi=t,14m9q=E,140BW=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,16w4E=t,13YJO=t,13ZFS=L,EBnq=t,pmqk=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,16w4E=E,1e85a=t,TPos=t,1e91e=L,TPos=t,1e85a=L,TPos=t,1gFq0=L,Ri3C=t,1gFq0=L,Ri3C=t,1gFq0=L,TPos=t,1e85a=L,TPos=t,1e85a=L,TPos=t,1gFq0=L,Ri3C=t,1gFq0=L,Ri3C=t,1gFq0=L,Ri3C=t,1gFq0=L,TPos=t,1e85a=L,TPos=t,1e85a=L,TPos=t,1gFq0=L,Ri3C=t,7EwUM=L,31NO8=t"
        )

        link("Etc/GMT+10", "Etc/GMT+9")

        insert(
            "America/Scoresbysund",
            "8K,-1Q6FdK=l,2c1tdm=s,11roY=l,13WRG=y,13XNK=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,16w4E=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,16w4E=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,13YJO=y,13YJO=s,16w4E=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,Ri3C=y,1gFq0=s,TPos=y,1e85a=s,TPos=y,1e85a=s,TPos=y,1gFq0=s"
        )

        insert(
            "Asia/Thimbu",
            "4S,-LNJH6=1Q,1nHxMo=r"
        )

        insert(
            "Asia/Kamchatka",
            "8L,-1CGufO=t,gfOvW=E,1KrKjS=V,14khi=E,13ZFS=V,14khi=E,13ZFS=V,14khi=E,14m9q=V,140BW=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,16w4E=E,13YJO=E,13ZFS=t,EBnq=E,pmqk=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,16w4E=V,1e85a=E,TPos=V,1e85a=E,TPos=V,1e85a=E,TPos=V,1gFq0=E,Ri3C=V,1gFq0=E,Ri3C=V,1gFq0=E,TPos=V,1e85a=E,TPos=V,1e85a=E,TPos=V,1gFq0=E,Ri3C=V,1gFq0=E,Ri3C=V,1gFq0=E,Ri3C=V,1gFq0=E,TPos=V,1e85a=E,TPos=V,1e85a=E,TPos=E,1gGm4=t,Ri3C=E"
        )

        link("Africa/Harare", "Africa/Kigali")

        link("Etc/GMT+12", "Etc/GMT+9")

        link("Etc/GMT+11", "Etc/GMT+9")

        link("Navajo", "America/Denver")

        insert(
            "America/Nome",
            "8M,-3wgI1x=8N,1886MF=21,1qznWK=2B,7uUlG=2C,gS64=21,JUTHq=14,4qsEg=15,13XNK=14,13ZFS=15,13XNK=14,13ZFS=15,16v8A=14,13ZFS=15,13XNK=14,13ZFS=15,13XNK=14,pois=15,1Izba=14,H9Ek=15,1qNPi=14,13ZFS=15,16v8A=14,11sl2=15,16v8A=14,13ZFS=15,13XNK=14,13ZFS=15,13XNK=14,13ZFS=15,13XNK=14,13ZFS=15,13XNK=14,13ZFS=15,16v8A=14,11sl2=15,16v8A=1a,bbXO=p,SLPW=q,13XNK=p,13ZFS=q,13XNK=p,13ZFS=q,13XNK=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,WnFm=q,1bzOg=p,WnFm=q,1bzOg=p,WnFm=q,1e796=p,TQkw=q,1e796=p,TQkw=q,1e796=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,JGZa=q,1ogus=p,Mek0=q,1ogus=p"
        )

        insert(
            "Europe/Tallinn",
            "8O,-36cXUo=4T,1jkJk4=0,qvgU=1,TPos=0,1GnnO=4T,3USHG=5,F95pG=K,2mO52=1,2pMzK=0,Ri3C=1,16w4E=0,13YJO=1,10ja8=K,1g04Jq=N,14khi=K,13ZFS=N,14khi=K,13ZFS=N,14khi=K,14m9q=N,140BW=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=N,13YJO=K,13YJO=6,13ZFS=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e91e=5,TPos=6,1gFq0=5,59KlG=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        link("Turkey", "Europe/Istanbul")

        insert(
            "Africa/Khartoum",
            "8P,-1lid0I=18,1lZGko=1g,YwEw=18,19qP6=1g,YT84=18,19NiE=1g,YT84=18,194ly=1g,ZfBC=18,18HS0=1g,ZC5a=18,18los=1g,ZYyI=18,17YUU=1g,10HvO=18,17fXO=1g,113Zm=18,19qP6=1g,YT84=18,194ly=1g,ZfBC=18,18HS0=1g,ZYyI=18,17YUU=1g,10l2g=18,17Crm=1g,10HvO=18,17fXO=1g,113Zm=18,19qP6=1g,ZfBC=18,18HS0=1g,ZC5a=18,ur8Oc=1n,C0dDG=18"
        )

        link("Africa/Johannesburg", "Africa/Mbabane")

        link("Africa/Bangui", "Africa/Malabo")

        link("Europe/Belgrade", "Europe/Skopje")

        link("Jamaica", "America/Jamaica")

        insert(
            "Africa/Bissau",
            "8Q,-1ZS5wg=s,2ay4HG=d"
        )

        link("Asia/Tehran", "Iran")

        insert(
            "WET",
            "g,fulpK=h,11roY=g,16w4E=h,13YJO=g,13YJO=h,13YJO=g,16w4E=h,11roY=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,16w4E=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,13YJO=h,13YJO=g,16w4E=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,Ri3C=h,1gFq0=g,TPos=h,1e85a=g,TPos=h,1e85a=g,TPos=h,1gFq0=g"
        )

        insert(
            "Europe/Astrakhan",
            "8R,-1zxkWE=J,d6MHi=n,1KrKjS=o,14khi=n,13ZFS=o,14khi=n,13ZFS=o,14khi=n,14m9q=o,140BW=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=n,13ZFS=J,13YJO=n,16w4E=J,13YJO=n,27Wxy=n,13ZFS=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,16w4E=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,7EwUM=J,31NO8=n"
        )

        insert(
            "Africa/Juba",
            "8S,-1licXa=18,1lZGgQ=1g,YwEw=18,19qP6=1g,YT84=18,19NiE=1g,YT84=18,194ly=1g,ZfBC=18,18HS0=1g,ZC5a=18,18los=1g,ZYyI=18,17YUU=1g,10HvO=18,17fXO=1g,113Zm=18,19qP6=1g,YT84=18,194ly=1g,ZfBC=18,18HS0=1g,ZYyI=18,17YUU=1g,10l2g=18,17Crm=1g,10HvO=18,17fXO=1g,113Zm=18,19qP6=1g,ZfBC=18,18HS0=1g,ZC5a=18,ur8Oc=1n"
        )

        insert(
            "America/Campo_Grande",
            "8T,-1VB2Hi=e,BUMPi=8,13r1u=e,1556w=8,13eQE=e,zB4oE=8,NiOA=e,1l18A=8,HQJi=e,1qtdS=8,IdcQ=e,1qtdS=8,wBXi=e,n0yiY=8,u4Cs=e,1XP4k=8,lnbi=e,1qPHq=8,wBXi=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,BK7iU=8,McrS=e,1jdGU=8,EArm=e,1tJvO=8,C36w=e,1tn2g=8,C36w=e,1vUn6=8,H7Mc=e,1tn2g=8,H7Mc=e,1qPHq=8,EArm=e,1vUn6=8,zvLG=e,1vUn6=8,JF72=e,1oimA=8,JF72=e,1oimA=8,H7Mc=e,1oimA=8,McrS=e,1m7vi=8,QUE0=e,1jdGU=8,McrS=e,1jdGU=8,Rh7y=e,1jdGU=8,McrS=e,1oimA=8,JF72=e,1vUn6=8,C36w=e,1qPHq=8,H7Mc=e,1wDkc=8,DRug=e,1oimA=8,JF72=e,1vUn6=8,EArm=e,1lL1K=8,JF72=e,1qPHq=8,H7Mc=e,1qPHq=8,JF72=e,1oimA=8,JF72=e,1oimA=8,McrS=e,1oimA=8,H7Mc=e,1qPHq=8,H7Mc=e,1qPHq=8,JF72=e,1oimA=8,JF72=e,1oimA=8,JF72=e,1oimA=8,JF72=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,EArm=e,1vUn6=8,C36w=e,1vUn6=8,EArm=e,1tn2g=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,EArm=e,1tn2g=8,EArm=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,C36w=e,1yrHW=8,C36w=e,1vUn6=8,EArm=e,1tn2g=8,C36w=e,1vUn6=8,C36w=e,1vUn6=8,EArm=e,1tn2g=8,EArm=e,1vUn6=8"
        )

        insert(
            "America/Belem",
            "8U,-1VB352=8,BUMgY=l,13r1u=8,1556w=l,13eQE=8,zB4oE=l,NiOA=8,1l18A=l,HQJi=8,1qtdS=l,IdcQ=8,1qtdS=l,wBXi=8,n0yiY=l,u4Cs=8,1XP4k=l,lnbi=8,1qPHq=l,wBXi=8,1qPHq=l,HufK=8,1qPHq=l,HQJi=8,BK7iU=l,McrS=8,1jdGU=l,EArm=8,1tJvO=l,C36w=8"
        )

        link("Etc/Greenwich", "Etc/GMT+9")

        link("Asia/Saigon", "Asia/Ho_Chi_Minh")

        link("America/Ensenada", "Mexico/BajaNorte")

        link("Pacific/Midway", "Pacific/Pago_Pago")

        link("America/Jujuy", "America/Argentina/Jujuy")

        link("Africa/Timbuktu", "Atlantic/St_Helena")

        link("America/Virgin", "America/Marigot")

        insert(
            "America/Bahia",
            "8V,-1VB3HC=8,BUMTy=l,13r1u=8,1556w=l,13eQE=8,zB4oE=l,NiOA=8,1l18A=l,HQJi=8,1qtdS=l,IdcQ=8,1qtdS=l,wBXi=8,n0yiY=l,u4Cs=8,1XP4k=l,lnbi=8,1qPHq=l,wBXi=8,1qPHq=l,HufK=8,1qPHq=l,HQJi=8,BK7iU=l,McrS=8,1jdGU=l,EArm=8,1tJvO=l,C36w=8,1tn2g=l,C36w=8,1vUn6=l,H7Mc=8,1tn2g=l,H7Mc=8,1qPHq=l,EArm=8,1vUn6=l,zvLG=8,1vUn6=l,JF72=8,1oimA=l,JF72=8,1oimA=l,H7Mc=8,1oimA=l,McrS=8,1m7vi=l,QUE0=8,1jdGU=l,McrS=8,1jdGU=l,Rh7y=8,1jdGU=l,McrS=8,1oimA=l,JF72=8,1vUn6=l,C36w=8,iv2Ra=l,McrS=8"
        )

        insert(
            "America/Goose_Bay",
            "8W,-2XFeiw=19,1bdcJG=1c,192tq=19,z4pDa=D,2nUqU=F,Rh7y=D,1gGm4=F,Rh7y=D,1gGm4=F,Rh7y=D,1jdGU=F,OJMI=D,1jdGU=F,Rh7y=D,1gGm4=F,Rh7y=D,1gGm4=34,6Y3So=35,gL4A=D,1jdGU=F,Rh7y=D,1gGm4=F,Rh7y=D,1gGm4=F,Rh7y=D,1gGm4=F,Rh7y=D,1jdGU=F,Rh7y=D,1bBGo=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1gGm4=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1e91e=F,TOso=D,1e91e=F,16v8A=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,13XNK=D,13ZFS=F,16v8A=D,MXh6=k,evwY=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,WlOc=m,1bzOg=k,WnFm=4U,1e6d2=k,TRgA=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1oilC=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,JGZa=m,1ogus=k,Mek0=m,1ogus=k"
        )

        insert(
            "America/Pangnirtung",
            "1s,-1GE7tu=k,J4NCU=26,7v0U8=27,gLxC=k,FMXeg=4U,16w4E=k,uWvYc=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,16v8A=k,11sl2=m,16v8A=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,13ZFS=m,13XNK=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=m,1e796=k,WnFm=m,1bzOg=k,WnFm=m,1bzOg=k,WnFm=m,1e796=k,TQkw=m,1e796=k,TQkw=4,1e85a=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=3,TRgA=7,1e796=2,TPos=4,1e796=2,WnFm=4,1bzOg=2,WnFm=4,1bzOg=2,WnFm=4,1e796=2,TQkw=4,1e796=2,TQkw=4,1e796=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        link("Asia/Katmandu", "Asia/Kathmandu")

        link("America/Phoenix", "US/Arizona")

        link("MST", "Etc/GMT+9")

        link("Africa/Niamey", "Africa/Malabo")

        link("America/Whitehorse", "Canada/Yukon")

        insert(
            "Pacific/Noumea",
            "8X,-1ZNVak=t,2gIU6E=E,uNzy=t,1D9U4=E,va36=t,BVKqA=E,wZmU=t"
        )

        insert(
            "Asia/Tbilisi",
            "8Y,-36cZ9Z=8Z,1wG0Tu=J,1872JV=n,Pr7B6=o,14khi=n,13ZFS=o,14khi=n,13ZFS=o,14khi=n,14m9q=o,140BW=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,16w4E=n,13YJO=n,13ZFS=J,13WRG=n,13XNK=J,13ZFS=n,13XNK=J,13ZFS=n,13XNK=n,13YJO=o,13XNK=n,16x0I=o,3m4CI=n,TQkw=o,1e796=n,TQkw=o,1gEtW=n,RiZG=o,1gEtW=n,RiZG=o,1gEtW=n,TQkw=o,1e796=n,TQkw=o,1e796=n,TQkw=o,wYqQ=n,JJNm=J,Ri3C=n"
        )

        link("America/Montreal", "Canada/Eastern")

        link("Asia/Makassar", "Asia/Ujung_Pandang")

        insert(
            "America/Argentina/San_Juan",
            "90,-2Ax4pK=1v,Sscbq=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=8,1lL1K=l,LtuM=e,ojNS=8,YaaY=l,McrS=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,93UI0=e,jX9e=8,7kee4=l,rTLa=8"
        )

        link("Hongkong", "Asia/Hong_Kong")

        link("UCT", "Etc/GMT+9")

        insert(
            "Asia/Nicosia",
            "4V,-1ENetO=5,1Q49sY=6,13XNK=5,1gjSw=6,S04E=5,115Ru=6,11qsU=5,16x0I=6,14khi=5,13Dck=6,13XNK=5,16x0I=6,11qsU=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,16v8A=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,16v8A=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,16x0I=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,1eaTm=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        insert(
            "America/Indiana/Winamac",
            "91,-2XUYbm=3,1bnUha=7,1e796=3,TQkw=7,1e796=3,LBHj2=1j,7uZ20=1m,gNpK=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=7,Rh7y=3,1gGm4=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,16v8A=3,13ZFS=7,13XNK=3,13ZFS=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1e91e=7,TOso=3,1gGm4=2,h4cdG=4,13XNK=2,13ZFS=4,13XNK=2,1dGboQ=7,1e85a=3,Mek0=4,1ofyo=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,JGZa=4,1ogus=2,Mek0=4,1ogus=2"
        )

        link("America/Argentina/ComodRivadavia", "America/Argentina/Catamarca")

        insert(
            "America/Boa_Vista",
            "92,-1VB2jS=e,BUMrS=8,13r1u=e,1556w=8,13eQE=e,zB4oE=8,NiOA=e,1l18A=8,HQJi=e,1qtdS=8,IdcQ=e,1qtdS=8,wBXi=e,n0yiY=8,u4Cs=e,1XP4k=8,lnbi=e,1qPHq=8,wBXi=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,BK7iU=8,McrS=e,1jdGU=8,EArm=e,1tJvO=8,C36w=e,oSVi0=8,Rh7y=e,1jdGU=8,2woM=e"
        )

        link("America/Grenada", "America/Marigot")

        insert(
            "Asia/Atyrau",
            "93,-1zwYI8=J,d6qsM=o,1Lw4Ba=r,13XNK=r,14ldm=o,13ZFS=r,14khi=o,14m9q=r,140BW=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,16w4E=o,13YJO=o,13ZFS=n,EBnq=o,pmqk=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,13YJO=r,13YJO=o,16w4E=r,1e85a=o,TPos=r,1e85a=o,TPos=r,1e85a=o,TPos=o,1gGm4=n,Ri3C=o,1gFq0=n,Ri3C=o,1gFq0=n,TPos=o,1e85a=n,TPos=o,1e85a=n,TPos=o,1gFq0=o"
        )

        link("Australia/Darwin", "Australia/North")

        insert(
            "Asia/Kuala_Lumpur",
            "94,-2nmti6=3g,9qo7D=v,WUO17=29,6oXy8=29,c6qxa=1G,YTUs=G,7CI40=1G,1fx6WI=A"
        )

        insert(
            "Asia/Khandyga",
            "95,-1IT6tf=A,mstxz=G,1KrKjS=L,14khi=G,13ZFS=L,14khi=G,13ZFS=L,14khi=G,14m9q=L,140BW=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,16w4E=G,13YJO=G,13ZFS=A,EBnq=G,pmqk=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,13YJO=L,13YJO=G,16w4E=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1e85a=G,TPos=L,1gFq0=G,Ri3C=L,1gFq0=G,Ri3C=L,1gFq0=G,TPos=L,1e85a=G,TPos=L,1e85a=G,og3C=L,vyoM=t,1gFq0=L,Ri3C=t,1gFq0=L,Ri3C=t,1gFq0=L,Ri3C=t,1gFq0=L,TPos=t,1e85a=L,TPos=t,1e85a=L,TPos=t,1gFq0=L,Ri3C=t,ZAd2=L,6EXDO=G"
        )

        link("Asia/Thimphu", "Asia/Thimbu")

        insert(
            "Asia/Famagusta",
            "96,-1ENew4=5,1Q49ve=6,13XNK=5,1gjSw=6,S04E=5,115Ru=6,11qsU=5,16x0I=6,14khi=5,13Dck=6,13XNK=5,16x0I=6,11qsU=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,16v8A=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,16v8A=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,16x0I=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,1eaTm=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,XKTe=J,2qS0o=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        link("Asia/Rangoon", "Asia/Yangon")

        link("Europe/Bratislava", "Europe/Prague")

        link("Asia/Calcutta", "Asia/Kolkata")

        insert(
            "America/Argentina/Tucuman",
            "97,-2Ax4Cw=1v,Sscoc=e,mBwdO=8,HQJi=e,19qP6=8,O0PC=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HufK=e,1qPHq=8,HQJi=e,If4Y=8,22vok=e,If4Y=8,3Pre8=e,rcGc=8,54EJW=e,1fAVq=8,AiUbS=e,rcGc=8,rTLa=e,1kFB6=8,NEm4=e,1kFB6=8,NEm4=e,1kFB6=8,ZfBC=e,13ZFS=8,16v8A=e,13ZFS=8,13XNK=e,13ZFS=8,9bvMs=l,zvLG=8,v9ybS=l,y3Ru=8,1jdGU=l,OJMI=8,1lL1K=l,McrS=e,1lLXO=l,MbvO=8,1lL1K=l,OJMI=8,e2rdK=8,T6rm=8,94hby=e,4mEE=8,7zsf6=l,rTLa=8,1gGm4=l,Rh7y=8"
        )

        insert(
            "Asia/Kabul",
            "98,-2KQHIc=n,1TsqfC=Z"
        )

        insert(
            "Indian/Cocos",
            "99,-2puMWM=1A"
        )

        insert(
            "Japan",
            "4W,-2P7McM=1z,24QC4g=22,McrS=1z,1bBGo=22,WlNe=1z,1oimA=22,JF72=1z,1oimA=22,JF72=1z"
        )

        insert(
            "Pacific/Tongatapu",
            "9a,-2nmytW=9b,1nquVi=V,21uUes=1e,Xs9W=V,1lK5G=1e,ur60=V,1DwnC=1e,ur60=V,vyz4I=1e,pnmo=V"
        )

        link("America/New_York", "US/Eastern")

        link("Etc/GMT-12", "Etc/GMT+9")

        link("Etc/GMT-11", "Etc/GMT+9")

        link("Etc/GMT-10", "Etc/GMT+9")

        insert(
            "Europe/Ulyanovsk",
            "9c,-1JRvB6=J,nqXlK=n,1KrKjS=o,14khi=n,13ZFS=o,14khi=n,13ZFS=o,14khi=n,14m9q=o,140BW=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=o,13YJO=n,13YJO=n,13ZFS=J,13YJO=n,16w4E=J,13YJO=J,13ZFS=1d,EBnq=J,pmqk=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,13YJO=n,13YJO=J,16w4E=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,Ri3C=n,1gFq0=J,TPos=n,1e85a=J,TPos=n,1e85a=J,TPos=n,1gFq0=J,Ri3C=n,7EwUM=J,31NO8=n"
        )

        link("Etc/GMT-14", "Etc/GMT+9")

        link("Etc/GMT-13", "Etc/GMT+9")

        link("W-SU", "Europe/Moscow")

        insert(
            "America/Merida",
            "9d,-1EvHTW=3,245u6Y=2,20H0A=3,svmaA=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,16x0I=7,Rh7y=3,16x0I=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,WnFm=7,1bzOg=3,WnFm=7,1bzOg=3,WnFm=7,1e796=3"
        )

        insert(
            "EET",
            "5,fulpK=6,11roY=5,16w4E=6,13YJO=5,13YJO=6,13YJO=5,16w4E=6,11roY=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        link("America/Rosario", "America/Argentina/Cordoba")

        link("Canada/Saskatchewan", "America/Regina")

        link("America/St_Kitts", "America/Marigot")

        link("Arctic/Longyearbyen", "Europe/Oslo")

        insert(
            "America/Fort_Nelson",
            "9e,-2XFapr=a,1bdd33=c,192tq=a,NJEME=1E,7uX9S=1F,gPhS=a,3m6uQ=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1gGm4=c,Rh7y=a,1gGm4=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1gGm4=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1e91e=c,TOso=a,1gGm4=c,Rh7y=a,1gGm4=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,16v8A=a,11sl2=c,16v8A=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,13ZFS=c,13XNK=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,WnFm=c,1bzOg=a,WnFm=c,1bzOg=a,WnFm=c,1e796=a,TQkw=c,1e796=a,TQkw=c,1e796=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,Mek0=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=c,1ogus=a,JGZa=9"
        )

        insert(
            "America/Caracas",
            "9f,-2KQzde=9g,LdKUI=1T,1OWUgs=e,1tHaaY=1T,hVvdm=e"
        )

        link("America/Guadeloupe", "America/Marigot")

        insert(
            "Asia/Hebron",
            "9h,-2nTKYL=5,1mIh6L=6,5a5Ta=5,SMM0=6,1fxba=5,T7nq=6,1fz3i=5,Yc36=6,1a9Mc=5,Yc36=6,1a61W=5,mtcsw=6,QbGU=5,1eRYk=6,TrYQ=5,1eSUo=6,T7nq=5,1fz3i=6,T7nq=5,1fczK=6,T7nq=5,1fczK=6,T7nq=5,1fczK=6,T7nq=5,1fz3i=6,T7nq=5,1fczK=6,T7nq=5,1fczK=6,TtQY=5,1eQ6c=6,cEO4=B,f8AOQ=C,zvLG=B,16x0I=C,McrS=B,kxVF6=C,TOso=B,1qPHq=C,EArm=B,1hLMI=C,SJ1K=B,1e91e=C,Rh7y=B,1oimA=C,JF72=B,1bBGo=C,TOso=B,1e91e=C,WlNe=B,1e91e=C,WlNe=B,1dq48=C,Uxpu=B,1dq48=C,S04E=B,1fXoY=C,Uxpu=B,Hw7S=5,yrh6=6,YU48=5,193pu=6,YU48=5,193pu=6,YU48=5,1e85a=6,13XNK=5,16x0I=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,YU48=5,193pu=6,10mUo=5,12Sn6=6,113Zm=5,17fXO=6,XPzy=5,19oWY=6,UTT2=5,1d3AA=6,WmJi=5,1bAKk=6,O0PC=5,1mtZO=6,IdbS=5,awKY=6,bdPW=5,13ZFS=6,11roY=5,16w4E=6,13XNK=5,13ZFS=6,1e796=5,UcO4=6,1dKFy=5,UdK8=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5,RiZG=6,1gEtW=5,TQkw=6,1e796=5,TQkw=6,1e796=5,TQkw=6,1gEtW=5,RiZG=6,1gEtW=5"
        )

        insert(
            "Indian/Kerguelen",
            "1s,-GIfsY=o"
        )

        insert(
            "Africa/Monrovia",
            "9i,-31VViY=9j,1hmceI=9k,1OSywW=d"
        )

        insert(
            "Asia/Ust-Nera",
            "9l,-1IT6WW=A,msu1g=G,1KrKjS=E,14ipa=t,13ZFS=E,14khi=t,13ZFS=E,14khi=t,14m9q=E,140BW=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,16w4E=t,13YJO=t,13ZFS=L,EBnq=t,pmqk=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,16w4E=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1gFq0=t,Ri3C=E,1gFq0=t,Ri3C=E,1gFq0=t,TPos=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1gFq0=t,Ri3C=E,1gFq0=t,Ri3C=E,1gFq0=t,Ri3C=E,1gFq0=t,TPos=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1gFq0=t,Ri3C=E,ZAd2=t,6EXDO=L"
        )

        link("Egypt", "Africa/Cairo")

        insert(
            "Asia/Srednekolymsk",
            "9m,-1zx548=L,d6qgk=t,1KrKjS=E,14khi=t,13ZFS=E,14khi=t,13ZFS=E,14khi=t,14m9q=E,140BW=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,16w4E=t,13YJO=t,13ZFS=L,EBnq=t,pmqk=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,13YJO=E,13YJO=t,16w4E=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1gFq0=t,Ri3C=E,1gFq0=t,Ri3C=E,1gFq0=t,TPos=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1gFq0=t,Ri3C=E,1gFq0=t,Ri3C=E,1gFq0=t,Ri3C=E,1gFq0=t,TPos=E,1e85a=t,TPos=E,1e85a=t,TPos=E,1gFq0=t,Ri3C=E,7EwUM=t"
        )

        insert(
            "America/North_Dakota/New_Salem",
            "9n,-2XUXfi=9,1bnUha=b,1e796=9,TQkw=b,1e796=9,LBHj2=1t,7uY5W=1B,gOlO=9,K5ros=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,pois=b,1Izba=9,H9Ek=b,1qNPi=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,16v8A=9,11sl2=b,16v8A=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,13ZFS=b,13XNK=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=9,WnFm=b,1e796=9,TQkw=b,1e796=9,TQkw=b,1e796=9,WnFm=b,1bzOg=9,WnFm=b,1bzOg=3,WmJi=7,1e796=3,TQkw=7,1e796=3,TQkw=7,1e796=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,JGZa=7,1ogus=3,Mek0=7,1ogus=3"
        )

        insert(
            "Asia/Anadyr",
            "9o,-1zx6y8=E,d6pSc=V,1KrKjS=1e,14khi=V,13ZFS=V,14ldm=E,13ZFS=V,14khi=E,14m9q=V,140BW=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,16w4E=E,13YJO=E,13ZFS=t,EBnq=E,pmqk=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,13YJO=V,13YJO=E,16w4E=V,1e85a=E,TPos=V,1e85a=E,TPos=V,1e85a=E,TPos=V,1gFq0=E,Ri3C=V,1gFq0=E,Ri3C=V,1gFq0=E,TPos=V,1e85a=E,TPos=V,1e85a=E,TPos=V,1gFq0=E,Ri3C=V,1gFq0=E,Ri3C=V,1gFq0=E,Ri3C=V,1gFq0=E,TPos=V,1e85a=E,TPos=V,1e85a=E,TPos=E,1gGm4=t,Ri3C=E"
        )

        link("Australia/Melbourne", "Australia/Victoria")

        insert(
            "Asia/Irkutsk",
            "9p,-36d2Sd=9q,1nyPTy=v,mdAZ3=A,1KrKjS=G,14khi=A,13ZFS=G,14khi=A,13ZFS=G,14khi=A,14m9q=G,140BW=A,13YJO=G,13YJO=A,13YJO=G,13YJO=A,13YJO=G,13YJO=A,13YJO=G,13YJO=A,13YJO=G,13YJO=A,13YJO=G,16w4E=A,13YJO=A,13ZFS=v,EBnq=A,pmqk=G,13YJO=A,13YJO=G,13YJO=A,13YJO=G,13YJO=A,13YJO=G,13YJO=A,16w4E=G,1e85a=A,TPos=G,1e85a=A,TPos=G,1e85a=A,TPos=G,1gFq0=A,Ri3C=G,1gFq0=A,Ri3C=G,1gFq0=A,TPos=G,1e85a=A,TPos=G,1e85a=A,TPos=G,1gFq0=A,Ri3C=G,1gFq0=A,Ri3C=G,1gFq0=A,Ri3C=G,1gFq0=A,TPos=G,1e85a=A,TPos=G,1e85a=A,TPos=G,1gFq0=A,Ri3C=G,7EwUM=A"
        )

        link("America/Shiprock", "America/Denver")

        link("America/Winnipeg", "Canada/Central")

        link("Europe/Vatican", "Europe/Rome")

        insert(
            "Asia/Amman",
            "9r,-1liddS=5,1sC42k=6,GoP6=5,1eRYk=6,TrYQ=5,1eRYk=6,TrYQ=5,1ferS=6,14GKQ=5,13Dck=6,TrYQ=5,1evuM=6,TrYQ=5,dT0Pu=6,14khi=5,1556w=6,13XNK=5,13ZFS=6,13XNK=5,13ZFS=6,16v8A=5,1ferS=6,SJ1K=5,1bBGo=6,WlNe=5,18los=6,X4Kk=5,194ly=6,11qsU=5,13ZFS=6,13XNK=5,13ZFS=6,YT84=5,1bBGo=6,WmJi=5,1bAKk=6,YU48=5,193pu=6,YU48=5,193pu=6,YU48=5,1FGiQ=6,uOvC=5,169B6=6,14ldm=5,13Cgg=6,14ldm=5,13YJO=6,13YJO=5,13YJO=6,1e85a=5,TPos=6,1bAKk=5,YU48=6,13YJO=5,13YJO=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,3Gnjq=5,zxDO=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5"
        )

        link("Etc/UTC", "Etc/GMT+9")

        link("Asia/Tokyo", "Japan")

        link("America/Toronto", "Canada/Eastern")

        link("Asia/Singapore", "Singapore")

        insert(
            "Australia/Lindeman",
            "9s,-2AaOrG=i,KYTkk=j,u6tC=i,QU95S=j,vwwE=i,13ZFS=j,13XNK=i,16x0I=j,11qsU=i,WWgVO=j,H8Ig=i,BJJTi=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,JG36=i,1ohqw=j,MdnW=i,1ohqw=j,JG36=i"
        )

        link("America/Los_Angeles", "US/Pacific-New")

        insert(
            "Pacific/Majuro",
            "9t,-2nmxDa=t,2mP1u0=E"
        )

        link("America/Argentina/Buenos_Aires", "America/Buenos_Aires")

        link("Europe/Nicosia", "Asia/Nicosia")

        insert(
            "Pacific/Guadalcanal",
            "9u,-1YgVTu=t"
        )

        insert(
            "Europe/Athens",
            "9v,-2yFSCo=9w,IzayM=5,y2YKY=6,khKE=5,imlq0=6,8k1y=1,3dOlq=0,RCF2=1,168F2=0,14m9q=5,hBbAA=6,IW9W=5,LVh2E=6,1kEF2=5,NHag=6,13YJO=5,11roY=6,11NSw=5,169B6=6,11sl2=5,16BH2=6,13uLK=5,153eo=6,13eQE=5,142u4=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,16w4E=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,13YJO=6,13YJO=5,16w4E=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,Ri3C=6,1gFq0=5,TPos=6,1e85a=5,TPos=6,1e85a=5,TPos=6,1gFq0=5"
        )

        link("US/Pacific", "US/Pacific-New")

        insert(
            "Europe/Monaco",
            "9x,-2IhR6I=2m,GGroL=g,bf7Gx=h,DvWM=g,114Vq=h,19pT2=g,TsUU=h,1euyI=g,QVA4=h,1h1Ty=g,LQUo=h,1tm6c=g,PtFS=h,1jzeo=g,SJXO=h,193pu=g,1lK5G=h,MdnW=g,11roY=h,16w4E=g,13YJO=h,13YJO=g,193pu=h,YU48=g,16w4E=h,11roY=g,193pu=h,11roY=g,193pu=h,YU48=g,16w4E=h,11roY=g,193pu=h,YU48=g,13YJO=h,13YJO=g,11roY=h,193pu=g,13YJO=h,13YJO=g,11roY=h,16w4E=g,193pu=h,YU48=g,13YJO=h,13YJO=g,11roY=h,16w4E=g,193pu=h,1gFq0=g,zzvW=h,2xEvm=1C,TOso=h,TQkw=1C,1ojiE=h,Ri3C=1C,16w4E=h,13YJO=1C,167IY=h,11PKE=1C,YxAA=0,13cvu0=1,13XNK=0,16xWM=1,11roY=0,16w4E=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,11roY=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,16w4E=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,13YJO=1,13YJO=0,16w4E=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,Ri3C=1,1gFq0=0,TPos=1,1e85a=0,TPos=1,1e85a=0,TPos=1,1gFq0=0"
        )

    }

    private fun parseOffsets(str: String): List<OffsetZone> =
        str.split(',').map { pattern ->
            val equals = pattern.lastIndexOf('=')
            val name = pattern.substring(0, equals)
            val offset = pattern.substring(equals + 1).toIntCaseSensitive(62)
            OffsetZone(name, offset)
        }

    private fun parseTzEntry(str: String): TzEntry =
        str.split(',', limit = 2).let { initialSplit ->
            val initial =
                offsets.getOrElse(initialSplit[0].toIntCaseSensitive(62)) { unknownZone }
            val sinces = if (initialSplit[1].isNotEmpty())
                initialSplit[1].splitToSequence(',').map {
                    val split = it.split('=', limit = 2)
                    val since = split[0].toLongCaseSensitive(62)
                    val offsetZone =
                        offsets.getOrElse(split[1].toIntCaseSensitive(62)) { unknownZone }
                    SinceData(since, offsetZone)
                }.toList() else emptyList()
            initial to sinces
        }

    private fun insert(
        name: String,
        str: String
    ) = _tzdata.put(name, TimeZone(name, lazy { parseTzEntry(str) }))

    private fun link(
        name: String,
        other: String
    ) = _tzdata.put(name, _tzdata[other]!!)
}
