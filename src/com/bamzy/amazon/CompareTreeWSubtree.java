package com.bamzy.amazon;

public class CompareTreeWSubtree {

    boolean compareNode(Integer[] src, Integer[] dst,int srcIndex, int dstIndex){
        if(srcIndex>=src.length && dstIndex>=dst.length) return true;
        else if (srcIndex<src.length && dstIndex < dst.length){

            if(src[srcIndex]==null && dst[dstIndex]==null) return true;
            if(src[srcIndex]==dst[srcIndex]){
                return compareNode(src,dst,srcIndex*2+1,dstIndex*2+1) && compareNode(src,dst,srcIndex*2+2,dstIndex*2+2)
            } else return false;
        } else return false;
    }
}
