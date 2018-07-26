package io.xdag.xdagwallet.api.xdagscan;

import android.support.annotation.Keep;
import android.text.TextUtils;
import io.xdag.common.Common;
import io.xdag.xdagwallet.R;
import java.util.List;

/**
 * created by lxm on 2018/7/24.
 */

@Keep
public class BlockDetailModel {

    public String block;
    public String time;
    public String timestamp;
    public String flags;
    public String state;
    public String file_pos;
    public String hash;
    public String difficulty;
    public String balance_address;
    public String balance;
    public List<BlockAsTransaction> block_as_transaction;
    public List<BlockAsAddress> block_as_address;


    public static class BlockAsTransaction {
        /**
         * direction : fee
         * address : 6LN4oKM6n3oEn/rvKSqLLcZnqiNpa4aa
         * amount : 0.000000000
         */

        public String direction;
        public String address;
        public String amount;
    }


    public static class BlockAsAddress {
        /**
         * direction : input
         * address : BFitL37q0R9NQecLP+NZfvJNxS7hFxyR
         * amount : 0.001000000
         * time : 2018-07-18 09:16:01.255
         */

        public String direction;
        public String address;
        public String amount;
        public String time;


        public int getTypeImage() {
            if (isInput()) {
                return R.drawable.ic_input;
            } else {
                return R.drawable.ic_output;
            }
        }


        public String getAmount() {
            if (isInput()) {
                return String.format("+%s", amount);
            } else {
                return String.format("-%s", amount);
            }
        }


        public int getAmountColor() {
            if (isInput()) {
                return Common.getColor(R.color.colorPrimary);
            } else {
                return Common.getColor(R.color.colorAccent);
            }
        }


        public boolean isInput() {
            return TextUtils.equals(direction, "input");
        }
    }
}
