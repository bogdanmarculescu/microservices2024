//import * as React from 'react';
import { useEffect, useState } from 'react';
//import RecorderApiClient from "../services/RecorderApiClient.ts";

interface Round{
    roundId: number;
    outcomeText: string;
}

const RoundsRecordedComponent = () => {
    const [rounds, setRounds] = useState<Round[]>([]);
    const [loading, setLoading] = useState<boolean>(true);

    const SERVER_URL = 'http://localhost:8000';

    useEffect(() => {
        const fetchRounds = async () => {
            try {
                const response = await fetch(SERVER_URL + '/record');
                const data: Round[] = await response.json();
                setRounds(data);
            } catch (error) {
                console.error('Error fetching data', error);
            } finally {
                setLoading(false);
            }
        };

        fetchRounds();
    }, []);

    if(loading){
        return <div> Still loading, I am... </div>
    }
    return(
        <div>
            <h2> Rounds </h2>
            <ul>
                {rounds.map((round, index) => (
                    <li key={index}>
                        <strong> {round.roundId} </strong> outcome {round.outcomeText}
                    </li>
                ))}
            </ul>
        </div>
    );
};

/*
class RoundsRecordedComponent extends React.Component {

    render() {
        const [rounds, setRounds] = useState<Round[]>([]);
        const [loading, setLoading] = useState<boolean>(true);

        useEffect(() => {
            fetch('/record')
                .then(response => response.json())
                .then(data => {
                    setRounds(data);
                    setLoading(false);
                })
                .catch(error => {
                   console.error('Error fetching records', error);
                   setLoading(false);
                });
        }, []);

        if(loading){
            return <div> Loading data ...  </div>
        }

        return (
            <div>
                <h3> Round List </h3>
                <ul>
                    {rounds.map((round, index) => (
                      <li key={index}>
                          <strong>{round.roundId}</strong> outcome {round.outcomeText}
                      </li>
                    ))}
                </ul>
            </div>
        );

    }

}


 */
export default RoundsRecordedComponent;