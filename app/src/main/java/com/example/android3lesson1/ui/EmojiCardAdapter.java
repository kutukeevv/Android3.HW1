package com.example.android3lesson1.ui;

import android.graphics.Color;
import android.net.sip.SipSession;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson1.R;
import com.example.android3lesson1.data.Card;

@RequiresApi(api = Build.VERSION_CODES.R)
public class EmojiCardAdapter extends RecyclerView.Adapter<EmojiCardAdapter.EmojiCardVH> {

    private final EmojiGame emojiGame = new EmojiGame();

    @Override
    public EmojiCardVH onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new EmojiCardVH(view, emojiGame);
    }

    @Override
    public void onBindViewHolder( EmojiCardAdapter.EmojiCardVH holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    class EmojiCardVH extends RecyclerView.ViewHolder{

        private final TextView tvCard;
        private final EmojiGame game;


        public EmojiCardVH( View itemView, EmojiGame game) {
            super(itemView);
            this.game = game;
            tvCard = itemView.findViewById(R.id.itemCard);
        }

        public void onBind(Card<String> card){
            if (card.isFaceUp()){
                tvCard.setText(card.getContent());
                tvCard.setBackgroundColor(Color.WHITE);
            }else {
                tvCard.setText("");
                tvCard.setBackgroundColor(Color.BLUE);
            }
            tvCard.setOnClickListener(v -> {
                game.choose(card);
                notifyDataSetChanged();
            });
        }
    }
    public interface onCardClick{
        void cardClick(Card<String> card);
    }
}
