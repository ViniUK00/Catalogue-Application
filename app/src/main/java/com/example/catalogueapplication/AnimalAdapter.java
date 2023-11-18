package com.example.catalogueapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private String Kiara = "The Yorkshire Terrier is a small dog with a big personality. They are feisty and loving, and they make great companions for people of all ages. Yorkies are also the most popular toy dog breed in the United States, and they have won many fans with their devotion to their owners, their elegant looks, and their suitability to apartment living.\n" +
            "Yorkies are known for their yappy tendencies, so they may not be the best choice for people who live in apartments with thin walls. They also require a bit of maintenance, especially when it comes to dental care. However, if you are willing to put in the effort, a Yorkshire Terrier can make a wonderful pet.";
    private String Capybara = "Capybara is a giant cavy rodent native to South America. It is the largest living rodent and a member of the genus Hydrochoerus. The only other extant member is the lesser capybara (Hydrochoerus isthmius). Its close relatives include guinea pigs and rock cavies, and it is more distantly related to the agouti, the chinchilla, and the nutria." +
            "The capybara inhabits savannas and dense forests, and lives near bodies of water. It is a highly social species and can be found in groups as large as 100 individuals, but usually live in groups of 10–20 individuals. The capybara is hunted for its meat and hide and also for grease from its thick fatty skin. It is not considered a threatened species.";

    private String CHINCHILLA = "Chinchillas are clean, quiet and attractive rodents that don't smell. They can live for 10-20 years, and they've been bred and farmed for their soft, dense fur. They're quite shy and are more appropriate as pets for adults and older children.\n" +
            "Chinchillas are soft-furred rodents with strong hind legs, large ears and a tail that makes up about a third of their body length. Here are some more facts about chinchillas" +
            "Chinchillas are athletic\nThey have long hind limbs adapted for leaping. They can jump over six feet in height, and pet chinchillas have been reported to jump onto the top of refrigerators!" +
            "Chinchillas are highly social\n" +
            "In the wild, they live in colonies of over 100 chinchillas." +
            "Chinchillas need a high-fibre diet\n" +
            "Their teeth grow constantly, so they need to eat lots of hay, which is abrasive, to help wear their teeth down.";
    private String Rabbit = "Rabbits, small mammals of the family Leporidae, are recognized for their iconic long ears, powerful hind legs, and fluffy tails. Ranging from 8 to 20 inches, they sport fur in diverse colors. Social and active during dawn and dusk, rabbits are herbivores with continuously growing incisor teeth, adapted for a diet rich in grasses and greens. Prolific reproducers, they are often kept as pets, showcasing various breeds with distinct features while maintaining their characteristic physical traits.";
    private int[] imageIds = {
            R.drawable.kiara,
            R.drawable.capybara,
            R.drawable.chinchilla,
            R.drawable.rabbit,
    };

    private String[] details = {
            Kiara,
            Capybara,
            CHINCHILLA,
            Rabbit,
    };

    private String[] animals = {
            "kiara",
            "capybara",
            "chinchilla",
            "rabbit",
    };

    private Context context;
    private OnItemClickListener listener;

    interface OnItemClickListener {
        void onItemClick(int imageResId, String details, String animal);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    AnimalAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catalog, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int imageId = imageIds[position];
        String animal = animals[position];

        holder.imageView.setImageResource(imageId);
        holder.textView.setText(animal);
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(imageId, details[position], animal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageIds.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
