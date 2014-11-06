package cs224n.corefsystems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cs224n.coref.ClusteredMention;
import cs224n.coref.Document;
import cs224n.coref.Entity;
import cs224n.coref.Mention;
import cs224n.util.Pair;

public class RuleBased implements CoreferenceSystem {

  @Override
  public void train(Collection<Pair<Document, List<Entity>>> trainingData) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<ClusteredMention> runCoreference(Document doc) {
    // TODO Auto-generated method stub
      // Initialize all mention as singleton.
      Map<Mention, ClusteredMention> clusters = new HashMap<Mention, ClusteredMention>();
      for(Mention m : doc.getMentions()){
          clusters.put(m, m.markSingleton());
      }
      // Create all combination pair of mentions.
      Set<Mention> seenMentions = new HashSet<Mention>();
      List<Pair<Mention, Mention>> mentionPairs = new ArrayList<Pair<Mention, Mention>>();
      for(Mention mi : doc.getMentions()) {
          seenMentions.add(mi);
          for(Mention mj : doc.getMentions()) {
              if (!seenMentions.contains(mj)) {
                  mentionPairs.add(new Pair<Mention, Mention>(mi, mj));
              }
          }
      }
      System.out.println("size" + doc.getMentions().size() + ", pairs:" + mentionPairs.size());
      // Multi-pass sieve (NLP 10')
      pass1(doc, clusters);
      
      // Create and return the mentions
      List<ClusteredMention> mentions = new ArrayList<ClusteredMention>();
      for (ClusteredMention cluster : clusters.values()) {
          mentions.add(cluster);
      }
      return mentions;
  }

  private void pass1(Document doc, Map<Mention, ClusteredMention> clusters) {
      return;
      for(Mention mi : doc.getMentions()){
          for(Mention mj : doc.getMentions()){
              if (mi == mj) {
                  continue;
              }
          }
      }
  }
}
