import React, { useMemo, useState } from 'react';
import { useParams } from 'react-router-dom';

const SAMPLE_QUESTION = {
  question: "Which planet is known as the Red Planet?",
  options: ["Earth", "Mars", "Jupiter", "Venus"],
  answerIndex: 1
};

export default function Game() {
  const { roomId } = useParams();
  const [selected, setSelected] = useState(null);
  const [locked, setLocked] = useState(false);

  const q = useMemo(() => SAMPLE_QUESTION, []);

  const choose = (i) => {
    if (locked) return;
    setSelected(i);
    setLocked(true);
  };

  const next = () => {
    // placeholder: just reset
    setSelected(null);
    setLocked(false);
  };

  const isCorrect = selected === q.answerIndex;

  return (
    <div className="max-w-2xl mx-auto mt-10 bg-white p-6 rounded-xl shadow">
      <div className="text-xs text-gray-500 mb-2">Room: {roomId}</div>
      <h2 className="text-xl font-bold mb-4">{q.question}</h2>

      <div className="grid gap-3">
        {q.options.map((opt, i) => {
          const picked = selected === i;
          const status =
            locked && i === q.answerIndex ? 'ring-2 ring-green-500' :
            locked && picked && i !== q.answerIndex ? 'ring-2 ring-red-500 opacity-60' :
            '';
          return (
            <button
              key={i}
              onClick={() => choose(i)}
              className={`text-left px-4 py-3 rounded border hover:bg-gray-50 ${picked ? 'bg-indigo-50 border-indigo-200' : ''} ${status}`}
            >
              {opt}
            </button>
          );
        })}
      </div>

      <div className="mt-4 flex items-center justify-between">
        <div className={`text-sm ${locked ? (isCorrect ? 'text-green-600' : 'text-red-600') : 'text-gray-500'}`}>
          {locked ? (isCorrect ? 'Correct! +10' : 'Wrong! 0') : 'Pick an option'}
        </div>
        <button onClick={next} className="px-4 py-2 rounded border">Next (placeholder)</button>
      </div>
    </div>
  );
}
